(ns tech.v3.datatype.main
  (:require [tech.v3.datatype.array-buffer :as array-buffer]
              [tech.v3.datatype.protocols :as dtype-proto]
              [tech.v3.parallel.for :as parallel-for]
              [primitive-math :as pmath])
  (:import [tech.v3.datatype DoubleReader])
  (:gen-class))


(defn -main
  [& args]
  (let [n-elems 10000000
        ^DoubleReader darray (dtype-proto/->reader
                              (array-buffer/array-buffer
                               (double-array (range n-elems))) {})
        sum (parallel-for/indexed-map-reduce
             n-elems
             (fn [^long start-idx ^long group-len]
               (let [end-idx (+ start-idx group-len)]
                 (loop [idx start-idx
                        sum 0.0]
                   (if (< idx end-idx)
                     (recur (unchecked-inc idx) (pmath/+ sum (.read darray idx)))
                     sum))))
             (partial reduce +))]
    (println sum)
    0))
