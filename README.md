# babel-usability-study

## Level 1 - Defining a Function and Syntax

In 1301 you used a functional language called Racket. This usability test is designed to improve the
error messages of another functional language called Clojure.
Similarly to Racket, Clojure is built on functions that take an input and return an output.

The syntax of defining a function in Clojure is slightly different than Racket.
This is a simple function in Racket:
```clojure
(define (add-three x) ; We define add-three to take x as input.
(+ 3 x)) ; The expression adds 3 to x.
```
Recall that Racket uses prefix notation for functions, meaning the + function comes before its inputs.
Unlike how a + is normally used in arithmetic, (3 + num).

The same function in Clojure:
```clojure
(defn add-three [x]
  (+ 3 x))
```
Clojure uses prefix notation for all functions.
```clojure
(- 20 3) ; Prefix notation is used in simple math functions
(count [21 4 90]) ; and for more interesting functions you'll learn about.
```
 To call the function add-three
### Problem 1: Fill in the blank to get the test to evaluate to true.
```clojure
(defn cheese? [str]
( = "cheese" ______))

(cheese? "cheese")
```

### problem 2 define a function called times-four that multiplies an input x by four

### Problem 3: define a function called greater-than-three that takes a number and returns true if it's bigger than three.


To define a global variable def is used.
```clojure
(def number 5)
(times-four number) ; This is how you call your times-four function on the variable you defined.
```

### Problem 3: def a variable called var to make this expression evaluate to true.
```clojure
(= var 7)
```

## Level 2 - If Statements (Introduce cond as well)
You're familiar with if statements from Racket. They're entirely identical in Clojure. This is the Syntax:
(if boolean-form
   then-form
   optional-else-form)

This is a function that takes a number and returns the letter grade corresponding to that number.
```clojure
(defn if-pos-neg [num]
  (if (>= num 0) "positive"
    "negative"))
```

Write a function absolute-value. That takes a number and returns the absolute value of that number.

## Level 3 - Vectors
A vector is like a list in Racket, it's used to store things. A vector can be concisely constructed like this:

### first Function
Takes a vector and returns the first item in that vector.
```clojure
(= 1 (first [1 2 3]))
```
Exercise: fill in the blank to make the expression evaluate to true.
```clojure
(= _____ (first ["apple" "cat"]))
```

#### Comment!!!!!!! empty? Function
Takes a vector and returns true if it's empty and false if it's not empty.
Exercise: use the empty? function on these vectors
```clojure
(def empty-vector [])
(def chz-vector ["cream cheese"])
```

#### rest Function
Takes a vector and returns a sequence of the elements after the first element.
```clojure
(println (= [2 3]  (rest [1 2 3])))
```

Exercise: fill in the blank to make the expression evaluate to true.
```clojure
(= "cat" (_____["apple" "cat"]))
```
```clojure
(def cheese-vector ["gouda cheese" "pepperjack cheese" "parmesean cheese" "asiago cheese" "american cheese"])
```
nth is a function that takes a vector, an integer, and returns the nth value in the vector.
Fill in the blanks to return the 4th item of the cheese-vector.
Vectors are 0 indexed 0 corresponds to "gouda cheese", 1 corresponds to "pepperjack cheese",
and 2 corresponds to "parmesean cheese"
```clojure
(= "american cheese" (nth ____ _____))
```

Recursion Problems
Recursion is a method of solving a problem by solving smaller and smaller versions of the problem until
the base case is reached. The base case is when the problem is small enough problem to where it can be solved, then the solution to
that problem can be used to solve the next problem. You used this concept to solve problems in Racket using
first, rest, and empty?. Those can be used similarily in Clojure.

Write a function to sum up all elements in a vector using, first, empty?, and rest
```clojure
(defn sum-vector [s]
  (if (empty? s)
    0
    (+ (first s) (sum-vector (rest s)))))
```

Write a function to return the last element in a vector

```clojure
(defn f[x]
(if
  (empty? (rest x))
  (first x)
  (f (rest x))))
```

#### Comment!!!!!!!
#### Conj
#### Use odd? to count odd numbers in vector
#### Phrase functions as returning true if a vector contains something

## Level 4 - Loop and Recur

Clojure has a recursive function Racket doesn't have called recur. Recur is usually used in conjunction with loop to bind values
for the recursion.


Definition:
Loop first binds given variables, evaluates whether the given argument is
true in relation to the given condition. If true, the given value goes through the recur argument and repeats the process.
If false, the value is directed to the base statement.

recur: directs the accumulated value to the loop
loop: sets a recursion point

Syntax:
loop [binding]
 (condition
    (statement)
    (recur (binding)))

```clojure
(defn countdown [x]
  (loop [x 10]
     (when (>= x 0) ;;;;;;; Side effects try sum all elements in a vector or finding the smallest element
       x
        (recur (- x 1)))))
        ;;;;; Probably don't need to introduce when.
```

```clojure
(defn  counting [x]
  (when (>= x 0)
  (println x)
  (counting (- x 1))))
```
```clojure
(defn factorial [n]
  (if (= n 1)
      1
      (* n (factorial (- n 1)))))
```

#### Don't necessarily need to put it in a function.
; Note: This uses multi-arity. Will have to explain what's happening
```clojure
(defn factorial
  ([n]; when only one argument is passed in
    (factorial n 1))
  ([n acc] ; when two arguments are passed in
    (if  (= n 0)  acc
    (recur (dec n) (* acc n)))))
```

## Level 5 - Putting it all together
You've learned the basics of defining functions. Vectors and a few predefined functions.
If statements. Written loop and recur functions. You have a foundation to try and solve a Problem
by writing your own function using all you've learned! Below is a vector containing the contents of a fridge represented by strings.
Your goal is to do a cheese audit. Write a function that takes a vector as input. Uses loop to bind variables you need. Use "include?"
to decide is a string has "cheese" it. If statements to decide if you should increment the cheese-count and recur or keep the same cheese-count and recur.

```clojure
(def cheese ["cheese" "sausage" "parmesean cheese"])
(def cheeses ["cheese" "pepperjack cheese" "asiago cheese" "hotdog" "apple"])
```

Note: Start by asking the study subject to write the function from scratch.
If they can't get it then they can get a version with fill in the blanks.
Do we need a final example or just ask them to put it all together?

```clojure
(defn cheese-counter [vector]
  (loop [n (dec (count vector)) cheese-count 0 v vector]
    (if (< n 0) cheese-count
      (if  (str/includes? (nth vector n) "cheese")
       (recur (dec n) (inc cheese-count) v)
       (recur (dec n) cheese-count v)
            )
        )
   ) ;;;;;; Index of first element that matches.
)
```
Put in markdown file. Examples in both. Just code in one file
