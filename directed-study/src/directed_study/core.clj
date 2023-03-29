(ns directed-study.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
)


; Module 1 - Defining a Function and Syntax.

(def var 5)

(def bool true)

(def str "banana")

(defn add-three [x]
  (+ 3 x))

(- 20 3); Prefix notation is used in simple math functions
(count [21 4 90]); and for more interesting functions you'll learn about.
(= 20 20); The equals sign is function that returns true if the values are equal.

; (defn cheese? [str]
; (= "cheese" ______))

; (cheese? "cheese")

; A function that takes multiple arguments

; Module 2 - If and Conditional Statements

(defn if-pos-neg [num]
  (if (>= num 0) "positive"
    "negative"))

(defn letter-grade [grade]
  (cond
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))

; Module 3 - Vectors

(empty? [])

(empty? [1 2 3])

(= 1 (first [1 2 3]))

; (= _____ (first ["apple" "cat"]))

(def empty-vector [])
(def chz-vector ["cream cheese"])

(rest [1 2 3])

(= [2 3]  (rest [1 2 3]))

(conj [1 2 3] 4)

; (= "cat" (__ ["apple" "cat"]))

(def cheese-vector ["gouda cheese" "pepperjack cheese" "parmesean cheese" "asiago cheese" "american cheese"])

; (= "american cheese" (nth ____ _____))

(defn sum-vector [vector]
  (if (empty? vector)
    0
    (+ (first vector) (sum-vector (rest vector)))))


(defn last-element [vector]
  (if (empty? (rest vector))
    (first vector)
    (last-element (rest vector))))

;; Use odd? to count odd numbers in vector

;; Write a function that returns true if a vector contains something

;; Module 4 - Loop and Recur

(defn sum-vector-2 [vector]
  (loop [v vector sum 0]
  (if (empty? v)
  sum
    (recur (rest v) (+ sum (first v))))))

;; Sum all elements in a vector

;; Find the smallest elements

(defn factorial [n]
  (if (= n 1)
      1
      (* n (factorial (- n 1)))))

(defn factorial-tail [n]
  (loop [n num acc 1]
    (if (= num 0)  acc
    (recur (dec num) (* acc num)))))


(def cheese ["cheese" "sausage" "parmesean cheese"])
(def cheeses ["cheese" "pepperjack cheese" "asiago cheese" "hotdog" "apple"])

(defn first-match-index [vector target]
  (loop [index 0 t target v vector]
    (if (= t (nth v index))
    index
    (recur (+ index 1) t v))))

;;;;;; Write a function that takes a vector of strings,
;;;  a string and returns the index index of the first
;; element that matches the given string.
; Put in markdown file. Examples in both. Just code in one file.
