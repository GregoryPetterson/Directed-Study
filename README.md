# babel-usability-study

## Level 1 - Defining a Function and Syntax

In 1301 you used a functional language called Racket. This usability test is designed to improve the
error messages of another functional language called Clojure.
Similarily to Racket, Clojure is built on functions that take an input and return an output.

To write your own function in Clojure is nearly identical, you need to define it.
Consider a function to add 3 to a number, in Racket it looks like this:
;;;;;;; (define (add-three x) We define the function named add-three to take the variable x as input.
;;;;;;; (+ 3 x)) The expression in the next line takes whatever the variable x is storing and adds 3 to it.
Recall that Racket uses prefix notation for functions, meaning the + function comes before its inputs.
Unlike how it's normally in arithmetic, (3 + num).

In Clojure it's very similar:
```clojure
(defn add-three [x] 
  (+ 3 x))
```
