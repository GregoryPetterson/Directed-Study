(ns directed-study.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;;;;;;;;;;;;;;;;;; Level 1 - Defining a Function and Syntax

; In 1301 you used a functional language called Racket. This usability test is designed to improve the
; error messages of another functional language called Clojure.
; Similarily to Racket, Clojure is built on functions that take an input and return an output.

; To write your own function in Clojure is nearly identical, you need to define it.
; Consider a function to add 3 to a number, in Racket it looks like this:
;;;;;;;; (define (add-three x)
;;;;;;;; (+ 3 x))
; In the first line, we define the function named add-three to take the variable x as input.
; The expression in the next line takes whatever the varaible x is storing and adds 3 to it.
; Recall that Racket uses prefix notation for functions, meaning the + function comes before its inputs.
; Unlike how it's normally in arithmetic, (3 + num).

; In Clojure it's very similar:
(defn add-three [x] ;We defn the function add-three to take the variable x as input. The variable is enclosed in brackets.
  (+ 3 x)) ; The expression in this example is identical, 3 is added to whatever variable x is storing.

; Problem 1: Fill in the Blank
; (defn cheese? [string]
; ( = "cheese" ______))

; Problem 2: define a function called times-four that multiplies an input x by four

; To define a global variable def is used.
(def num 5) ; You can call your times-four function on num like this:
; (times-four num)

; Problem 3: def a variable called variable to make this expression evaluate to true.
; (= varaible 7)

;;;;;;;;;;;;;;;;;; Level 2 - Vectors
; A vector is like a list in Racket, it's used to stor things. A vector can be concisely constructed like this:

(def cheese-vector ["gouda cheese" "pepperjack cheese" "parmesean cheese" "asiago cheese" "american cheese"])

; nth is a function that takes a vector, an integer, and returns the nth value in the vector.
; Fill in the blanks to return the 4th item of the cheese-vector.
; Vectors are 0 indexed. 0 corresponds to "gouda cheese", 1 corresponds to "pepperjack cheese", 2 corresponds to "parmesean cheese"

;(nth ____ _____)



;;;;;;;;;;;;;;;;;; Level 3 - If Statements
; You're familiar with if statements from Racket. They're entirely identical in Clojure. This is the Syntax:
; (if boolean-form
;   then-form
;   optional-else-form)

; This is a function that takes a number and returns the letter grade corresponding to that number.
(defn grade [x]
  (if (>= x 90) "A")
  (if (>= x 80) "B")
  (if (>= x 70) "C")
  (if (>= x 60) "D")
  (if (< x 60) "B")
  )

  (grade 82)

; Write a function absolute-value. That takes a number and returns the absolute value of that number.



;;;;;;;;;;;;;;;;;; Level 4 - Loop and Recur

; Recursion is a method of solving a problem by solving smaller and smaller versions of the problem until
; the base case is reached. The base case is when the problem is small enough problem to where it can be solved, then the solution to
; that problem can be used to solve the next problem.


; Definition:
; Loop first binds given variables, evaluates whether the given argument is
; true in relation to the given condition. If true, the given value goes through the recur argument and repeats the process. If false, the value is directed to the base statement.
;
; recur: directs the accumulated value to the loop
; loop: sets a recursion point
;
; Syntax:
; loop [binding]
; (condition
;    (statement)
;    (recur (binding)))

(defn countdown [n]
  (loop [x 10]
     (when (>= x 0)
       x
        (recur (- x 1)))))

;;;;;;;;;;;;;;;;; Both are the same. How do I explain the point of recur.
;;;;;;;;;;;;;;;;; If it's to guarantee that the JVM optimizes it.
;;;;;;;;;;;;;;;; Note: if they try non-tail recursion with recur, a java exception is thrown.

(defn  counting [x]
  (when (>= x 0)
  (println x)
  (counting (- x 1))))

(defn factorial [n]
  (if (= n 1)
      1
      (* n (factorial (- n 1)))))

; Note: This uses multi-arity. Will have to explain what's happening
(defn factorial
  ([n]; when only one argument is passed in
    (factorial n 1))
  ([n acc] ; when two arguments are passed in
    (if  (= n 0)  acc
    (recur (dec n) (* acc n)))))

;;;;;;;;;;;;;;;;;; Level 5 - Putting it all together
; You've learned the basics of defining functions. Vectors and a few predefined functions.
; If statements. Written loop and recur functions. You have a foundation to try and solve a Problem
; by writing your own function using all you've learned! Below is a vector containing the contents of a fridge represented by strings.
; Your goal is to do a cheese audit. Write a function that takes a vector as input. Uses loop to bind variables you need. Use "include?"
; to decide is a string has "cheese" it. If statements to decide if you should increment the cheese-count and recur or keep the same cheese-count and recur.

(def cheese ["cheese" "sausage" "parmesean cheese"])
(def cheeses ["cheese" "pepperjack cheese" "asiago cheese" "hotdog" "apple"])

; Note: Start by asking the study subject to write the function from scratch.
;; If they can't get it then they can get a version with fill in the blanks.

(defn cheese-counter
  ([vector]; when only one argument is passed in
    (cheese-counter (dec (count vector)) 0 vector))
  ([n cheese-count vector]; when two arguments are passed in
    (if (< n 0) cheese-count
      (if  (str/includes? (nth vector n) "cheese")
       (recur (dec n) (inc cheese-count) vector)
       (recur (dec n) cheese-count vector)
            )
        )
   )
)
;;;;;;;;;;;;;; Same function but it uses loop instead of arity. Not sure which
;;;;;;;;;;;;;; is more understandable for a beginner.
; (defn cheese-counter [vector]
;   (loop [n (dec (count vector)) cheese-count 0 v vector]
;     (if (< n 0) cheese-count
;       (if  (str/includes? (nth vector n) "cheese")
;        (recur (dec n) (inc cheese-count) v)
;        (recur (dec n) cheese-count v)
;             )
;         )
;    )
; )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; PATH 2 ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; Should I  try to incorporate Hash-maps and lazy seq?

;;;;;;;;;;;;;;;;;; Level 1 - Defining a Function and Syntax

; In 1301 you used a functional language called Racket. This usability test is designed to improve the
; error messages of another functional language called Clojure.
; Similarily to Racket, Clojure is built on functions that take an input and return an output.
; Defining a simple function in Clojure is nearly identical.

; Consider a function to add 3 to a number, in Racket it looks like this:
;;;;;;;; (define (add-three num)
;;;;;;;; (+ 3 num))
; In the first line, we define the function named add-three to take the variable num as input.
; The expression in the next line takes whatever the varaible num is storing and adds 3 to it.
; Recall that Racket uses prefix notation for functions, meaning the + function comes before its inputs.
; Unlike how it's regularily written, (3 + num).

; In Clojure it's very similar:
(defn add-three [num] ;We defn the function add-three to take the variable num as input. The variable is enclosed in brackets.
  (+ 3 num)) ; The expression in this example is identical, 3 is added to whatever variable num is storing.



;;;;;;;; cond Statement
; Conditional statement is made up of pairs of tests and expressions.
; A cond evaluates expressions and for the first expression that evaluates to true, it outputs whatever is to the right of that expression.
; The function pos-neg-else-zero takes a num and outputs "negative", "positive", or "zero."
(defn pos-neg-else-zero [num]
  (cond
    (< num 0) "negative"
    (> num 0) "positive"
    :else "zero"))

; Write a function that uses a cond differently. It takes a string as an input and returns

;;;;;;; if Statement
; An if statement evaluates an expression.
; If that expression evaluates to true


;;;;;;;; count Function
(=  5 (count "hello"))
; Exercise: fill in the blank
(=  11 (count "hello world"))

;;;;;;;;;;;;;;;;; Level 2 - Collections and functions that take collections as an input
; A hashmap (also called just "map") is a collection that maps keys to values.
; They’re a way of associating a value with another value.
; A key can be anything it typically starts with a colon.
; For example :a, :7, :hello, and :h7 are all keys

;;;; Explain nil
; When you look for something in a collections and can't find it

;;;;;;; hashmap Collection
(= 12 (:banana {:apple 1, :banana 12, :cat 34}))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= 1 (:apple {:apple 1, :banana 12, :cat 34}))


;;;;;;; vector Collection
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; Do we need to introduce lists and vectors?
; Or just choose one and stick with it.



;;;;;;;;;; first Function
; Takes a collection and returns the first item in that collection.
(= 1 (first [1 2 3]))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= "apple" (first ["apple" "cat"]))

;;;;;;;;;;; rest Function
; Takes a collection and returns a sequence of the elements after the first element.

;;;;;;;;;;; empty? Function
; Takes a collection and returns true if it's empty and false if it's not empty.
; Example:
(= [2 3]  (rest [1 2 3] ))
; Exercise: replace n with an integer to make the expression evaluate to true.
(= "cat" (rest ["apple" "cat"]))

;;;;;;;;;; conj Function
; Takes a collection and an element and returns a new collection with the
; element inserted at the beginning or the end depending if its a vector or a
; list.

;;;;;;;;;;;;;;;;;;Level 3 - Writing more complex functions

;;;;;;;;;; avoid when use if or cond instead
; remove println

;;;;;;; loop and recur problem
(loop [x 10]
  (when (> x 1)
    ;(println x)
    (recur (- x 2))))

;;;;;;;; Recursion Problems
; Write a function to return the last element in a vector

(defn f[x]
(if
  (empty? (rest x))
  (first x)
  (f (rest x))))


; Write a function to sum up all elements in a vector using, first, empty?, and rest
(defn sum-vector [s]
  (if (empty? s)
    0
    (+ (first s) (sum-vector (rest s)))))

(defn sum-vector [s]
  (loop [ls s, acc 0]
    (if (empty? ls)
      acc
    (recur (rest ls) (+ acc (first ls))))))

;;;;;;;;;;;;;;;;;;;;Level 4 - Higher order functions

;;;;;;;;;; Loop Recur
(defn LR-practice [])


;;;;;;; if Statement
; An if statement evaluates an expression.
; If that expression evaluates to true

;;;;;;;;;;;;;;;;;;;;Level 4 - Higher order functions

;;;;;;;;;; Let
; Let takes a vector containing pairs and binds values to variables.
;Examples:
(let [x 0] x)
(= 10 (let [x 5 y 5] (+ x y)))


;;;;;;;;;;;; Suffix problem
; Write a function that takes a string and recursively builds a list of all possible suffixes of the string.
