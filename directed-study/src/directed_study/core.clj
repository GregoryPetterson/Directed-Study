(ns directed-study.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

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


; Exercise: define a function called timesfour that multiplies an input x by four

;;;;;;;;;;;;;;;;;; Level 2 - Vectors

; Explain nil for when you look for something and ca't find it.

;;;;;;;;;;;;;;;;;; Level 3 - Count

;;;;;;;;;;;;;;;;;; Level 4 - If

;;;;;;;;;;;;;;;;;; Level 5 - Loop and Recur

;;;;;;;;;;;;;;;;;; Level 6 - Count Function

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
    (println x)
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
; Write a function that takes a list and returns every suffix of that list. Starting with the longest suffix and ending with the shortest suffix

;(defn suffix[list]
;  (if (empty? list)
; (conj list suffix[(rest list)]))
