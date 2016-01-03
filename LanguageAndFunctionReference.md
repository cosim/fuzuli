# Fuzuli Function Reference #


## built-in ##


### def ###

(def {variable} {type} )

def is used for defining variables for given types.

Types are 1,2,3,4 or INTEGER, FLOAT, STRING and LIST. These identifiers are defined at the start up process of interpreter. Both corresponding numbers and identifiers can be used.

```lisp
# defining an integer
(def i INTEGER)

# defining a float
(def f FLOAT)
# this is the same
(def f 2)# defining a string
(def s STRING)


# defining a list
(def aList LIST).```

## built-in ##


### + ###

(+  {reference} {reference} ... )

Returns sum of  given numbers or values  as parameters.

This function can take infinite number of parameters.

```lisp
# Sum 2 and 2
( +  2 2)

# Sum a and b and c
( +  a b c)

.```

## built-in ##


### - ###

Subtraction Operator

(- {reference} {reference})



```lisp
# answer is 2
(- 5 3)```

## built-in ##


### / ###

(/ {reference} {reference})

Return the division of first parameter to second.

.

```lisp
# Returns 5
(/ 25 5)```

## built-in ##


### = ###

( = {reference} {reference} )



Tests if first reference equals to other. If there is equality, returns 1 else returns 0.



```lisp
# Returns 1
(= 5 5)

# Returns 0
(= 5 6)```

## built-in ##


### != ###

Not equals operator.

( != {reference} {reference}

Tests if first reference equals to second one. If there is equality returns zero else returns 1.

This operator is for writing

(not (= a 5))

style codes in a shorter manner like

(!= a 5)




```lisp
# Returns zero
(!= 5 5)

# Returns one
(!= 5 4)
```

## built-in ##


### < ###

Smaller than operator.



( < {reference} {reference} )

Returns 1 if first reference is smaller than second one in value else returns zero.



```lisp
# Returns 1
( < 54 100)

# Returns 0
( < 100 54)
```

## built-in ##


### <= ###

(<= {reference} {reference})

Returns 1 if first reference is equals or smaller than second one else returns zero.



```lisp
# Returns 1
(<= 5 5)

# Returns 0
(<= 10 5)

```

## built-in ##


### > ###

(> {reference} {reference})

Returns 1 if first reference is bigger than the second one in value else returns 0.



```lisp
# Returns 1
(> 10 5)

# Returns 0
(> 5 10)
```

## built-in ##


### >= ###

(>= {reference} {reference})

Returns 1 if first reference is bigger or equal to second one in value else returns 0.



```lisp
# Returns 1
(>= 5 5)

# Returns 0
(>= 4 5)
```

## built-in ##


### ++ ###

(++ {reference})

Increment operator.

Increments the value of a given parameter by 1.
Returns the new value.

This function does what 'inc' function does.

```lisp
(def i INTEGER)
(let i 10)
(++ i)

# i is now 11

(inc i)

# i is now 12

```

## built-in ##


### -- ###

Decrement function.

This functions reduces the value of a given parameter by 1.




```lisp
(let i 10)
(-- i)
# i is now 9

(-- (-- i))
# i is now 7```

## built-in ##


### : ###

( : {reference} {reference}

Returns a list containing integers from first reference to second.


This function creates and returns a list.
First reference should be smaller than the second one. Otherwise, returns an empty list.

```lisp
# a is a list of 1,2,3,4,5,6,7,8,10
(let a (: 1 10))

# b is an empty list
(: 10 8)


```

## built-in ##


### << ###

(<< {reference} {reference})

Bitwise bit-shift to left.



```lisp
#Bitwise Shift to left
(<< 4 1)
# Result is 8```

## built-in ##


### >> ###

Bitwise right shift operator

Shift bits to right.



```lisp
# Returns 4
(>> 8 1) ```

## built-in ##


### & ###

(& {reference} {reference})

Returns an integer as a result of bitwise and operation between first and second references.



```lisp
# Returns 8
(& 72 184) ```

## built-in ##


### and ###

(and {reference} {reference})

Returns 1 if both parameters are 1 else returns 0.



```lisp
# Returns 1
(and (= 4 4) (=5 5))

# Returns 0
(and (< 1 5) (> 10 11))

```

## built-in ##


### or ###

(or {reference} {reference})


Returns 1 if at least one of the references is 1 else 0.



```lisp
# Returns 1
(or 1 0)

# Returns 0
(or 0 0)```

## built-in ##


### not ###

(not {reference})

Returns 1 if reference is 0 else returns 0



```lisp
# Returns 1
(not 0)

# Returns 0
(not 1)
```

## built-in ##


### if ###

(if {condition}
> {expressions}
)

or

(if {condition}
> {expressions}
> {expressions}
)


Evaluates expressions if a given condition is 1.

This expression has two forms. The first one is IF-THEN case. Second one includes an ELSE case. ELSE case is optional.




```lisp
(if (= 0 0)
(print "Ok")
)



# In this sample, if zero equals to zero than prints "Ok" else prints "Not Ok".
# Within (block) expression, more than one expressions can be evaluated
# when the condition holds or not.
(if (= 0 0)
(block
(print "Ok")
)

(block
(print "Not Ok")
)
)
```

## built-in ##


### foreach ###

(foreach {reference} in {list}
> {expressions}
)

This is a nice replacement of \'for\' expression.



```lisp
# Writes elements in mylist in a loop
(let mylist (list 1 2 3 4 5))
(foreach i in mylist
(print i " ")
)




# Basic loop
# Writes
# 1
# 101
# 2
# 102
# ...
(let a (list))
(foreach i in (: 1 10)
(print i "n")
(print (+ i 100) "n")
)

```

## built-in ##


### append ###

(append {list-reference} {expression})

Appends expression to the list list-reference and returns the expanded list as a new object.



```lisp
# Create a list with elements 46, 37, 41
(let a (list 46 37 41))

# Add 79 to list
(let a (append a 79)

# Print out content of the list
(foreach element in a
(print element " - ")
)
(print "n")
(print "Size of array: " (length a) "n")

# Output is
# 46 - 37 - 41 - 79 -
# Size of array: 4
```

## built-in ##


### block ###

(block {expression} {expression} ...)

Creates a new variable scope.
It is recommended that not to use block expressions in loops. Each block defines its own environment by consuming more memory.

Block expression is used in functions, if the function body includes more than one expressions.
Block is not needed in loop expressions such as for, foreach and while.

Block is needed in (if) expressions, if the (if) expression has more than one sub-expressions. Block also used to determine whether the (if) statement is in if-then or if-then-else form.

Block is generally used for creating a local variable scope for a bunch of code sequence.



```lisp
(let a 10)

(block
(let b 20)
(let a 20)
)

(print "a is " a "n")
(print "b is " b "n")

# Output is
# a is 20
# b is NULL
# because b is local to block and is not accessible in the global scope.





# Using block in a function defination
(function sum (params x)
(block
(def mysum FLOAT)
(let mysum 0.0)
(foreach element in x
(let mysum (+ mysum element))
)
(return mysum)
)
)



# Using block in if/then/else expressions
(let a 10)
(if (< a 20)
(block
(print "a is less than 20")
(print "Changing its value to 19")
(let a 19)
)

(block
(print "a is not less than 20")
(print "Value will not be changed")
)
)


```

## built-in ##


### break ###

(break)

Breaks a loop.



```lisp
# Creating a list
(let a (list 1 2 3 -1 30 44))

# Looping. If current element is negative
# than loop terminates.
(foreach element in a
(if (< element 0)
(block
(print "Negative found. breakingn")
(break)
)
)
(print element "n")
)

# Output is
# 1
# 2
# 3
# Negative found. breaking



```

## built-in ##


### C ###

(C {library-reference} {function-name} {parameters...})

Calls a C function from an external dynamic library given with {library-reference}

Dynamic libraries are loaded using the dynload function. Once a dynamic library loaded, the included C functions are directly callable from within Fuzuli.

C function must be defined using

extern \"C\"{
}

if the dynamic library is written in C++.

C functions must follow a pattern in order to be called in Fuzuli. Every function must return a Token**which is defined in FuzuliTypes.h. Functions must take 2 parameters. The pattern is defined as**

Token **aFunction (Token**params, Environment **env);**


In Fuzuli Core library, mathematical sine function is defined as

extern \"C\" {
Token **floord(Token**params, Environment **env);
}**

and it is implemented as

Token **floord(Token**params, Environment **env){
> double f\_result = floor(params->tokens[0](0.md)->getFloatValue());
> Token**result = env->newToken(f\_result, FLOAT);
> return(result);
}

Since the function floor takes only one parameter, params->tokens[0](0.md) is passed from interpreter. This function pattern is capable to take infinite number of parameters.



```lisp
# Loading FuzuliCore dynamic library
(let mathlib (dynload "FuzuliCore"))

# Wrapper function for floord
(function floor (params x )
(return (C mathlib "floord" x))
)

```

## built-in ##


### case ###

(switch x
> (case a (expression1))
> (case b (expression2))
> (case c (expression3))
> ...
)

Switch evaluates expression1 if x equals to a or evaluates expression2 if x equals to b or evaluates expression3 if x equals to c.




```lisp
(let a 2)

(switch a
(case 1
(print "a is 1")
)

(case 2
(print "a is 2")
)

(case 3
(print "a is 3")
)
)

# Result is
# a is 2
```

## built-in ##


### dump ###

(dump)

Dumps internally created variables in a variable scope.




```lisp
(let a 10)
(dump)

# Output is
# 0 - FLOAT 2 Kll:0
# 0 - INTEGER 1 Kll:0
# 0 - LIST 4 Kll:0
# 0 - NULL 5 Kll:0
# 0 - STRING 3 Kll:0
# 0 - a 10 Kll:0
# 0 - argc 2 Kll:0
# 0 - argv @FuzuliList Kll:0
# Tokens 19



# When dump is called in a local scope
# current variables in this scope and higher level
# scope is reported. The integer written before the
# variable name indicates the level of scope. The
# level of zero corresponds to global scope.
(let a 10)
(block
(let b 20)
(dump)
)

# Output is
# 1 - b 20 Kll:0
# 0 - FLOAT 2 Kll:0
# 0 - INTEGER 1 Kll:0
# 0 - LIST 4 Kll:0
# 0 - NULL 5 Kll:0
# 0 - STRING 3 Kll:0
# 0 - a 10 Kll:0
# 0 - argc 2 Kll:0
# 0 - argv @FuzuliList Kll:0
# Tokens 30


```

## built-in ##


### dynload ###







```lisp
```

## built-in ##


### eval ###

(eval {string-expression})

or

(eval expression}

Runs and returns the result of given program referenced by {string-expression} or expression.

The parameter passed for eval should be either a string or expression.

This function is similar to eval function that implemented in Php and Javascript.

```lisp
(let code "(let a 10)(let b 20)(let c (+ a b))")
(print "Running code:n")
(let result (eval code))
(print "Result is : " result "n")

# Output is
# Running code:
# Result is : 30




# myexp handles the generated abstract syntax tree
# and does not runs the code. There is no output
(let myexp
(expression
(print "Fuzuli Programming Language")
)
)

# Now, Fuzuli Programming Language is appeared
# in the console. Expression is evaluated by eval.
(eval myexp)
```

## built-in ##


### explode ###

(explode {string-reference} {seperator})

Parses a string by a given seperator and returns a list that contains the parsed content.



```lisp
# Parsing a string by spaces
(let a "Fuzuli Programming Language")
(let parselist (explode a " "))
(print parselist)

# The output is
# [Fuzuli, Programming, Language]```

## built-in ##


### fork ###







```lisp
```

## built-in ##


### function ###

(function {functionname} (params {expression1} {expression2} ...)

(block
> {expression}
> {expression}
> ...
> (return {expression})
)

)

Defines a Fuzuli function.



```lisp
# Defining a sum function.
# sum takes a list as parameter and
# returns the sum of contents of this list
(function sum (params x)
(block
(def mysum FLOAT)
(let mysum 0.0)
(foreach element in x
(let mysum (+ mysum element))
)
(return mysum)
)
)

# Creating a list
(let mylist (list 1 5 7 10))

# Calling sum function
(let mysum (sum mylist))

(print mysum "n")
# Result is 23

# An example for two parameter functions
# If there is only one expression in the
# function body, there is no need to use
# a block expression
(function min (params x y)
(if (< x y)
(return x)
(return y)
)
)

# Calling min for 5 and 9
(print (min 5 9) "n")

# Calling min for 67 and 1
(print (min 67 1) "n")


# Output is
# 5
# 1

```

## built-in ##


### gc ###

(gc)
(gc true | false)

(gc) manually starts the garbage collector. By default, Fuzuli\'s garbage collector automatically cleans the garbage. It is disabled by calling (gc false). Calling (gc true) enables the automatic garbage collector.

In current version, automatic garbage collection works well and standard user does not need to disable the automatic garbage collector utility.





```lisp
# Disabling autmatic garbage collector
(gc off)

# Setting limit to 1000000
(let limit 1000000)
(print "Creating array of 0..." limit "\n")

# Creating a list of integer from 1 to 1000000
(let a (: 0 limit))
(print "Array created with length " (length a) "\n")
(dump)

# Setting a to NULL
# So we have too much garbage
(let a NULL)

# Calling garbage collector manually
(print "Gargabe Collecting manually:\n")
(gc)

# Writing information of objects in memory
(dump)
```

## built-in ##


### getcookie ###







```lisp
```

## built-in ##


### html ###

<?html

html code

?>

Defines html code areas in Fuzuli code. This is usable in CGI scripts.



```lisp
#!/usr/lib/fuzuli/fuzuli

(print "Content-type: text/html\n\n")

<?html
<html>
<body>
<h1>Hello!

Unknown end tag for &lt;/h1&gt;


?>

(print " from Fuzuli")

<?html


Unknown end tag for &lt;/body&gt;




Unknown end tag for &lt;/html&gt;


?>


```

## built-in ##


### include ###







```lisp
```

## built-in ##


### isset ###

(isset {reference})

Returns 1 if the given reference is defined, else returns 0.



```lisp
#!/usr/bin/fuzuli
(print "Content-type: text/htmlnn")

<?html
<form>
<input type="text" name="pass">
<input type="submit" name"DoIt" value="result">


Unknown end tag for &lt;/form&gt;


?>

(let value (REQUEST "pass"))
(if (isset value)
(if(= value "fuzuli")
(print "<script>alert('SUCCESS!');

Unknown end tag for &lt;/script&gt;

")
(print "<script>alert('OPPS!');

Unknown end tag for &lt;/script&gt;

")
)

)
<?html
<b>The Password is: <u>fuzuli

Unknown end tag for &lt;/u&gt;



Unknown end tag for &lt;/b&gt;


?>```

## built-in ##


### length ###

(length {list-reference})

Returns number of elements of list {list-reference}.
If {list-reference} is not a list, returns 0.



```lisp
# Result is 5
(let a (list 1 1 7 4 10))
(let len (length a))
(print a "\n")
```

## built-in ##


### let ###

(let identifier {reference | constant} )

let assigns values to variables. If the variable is already defined in higher scopes, the value of original variable is changed. If the variable subject to assign does not exist, a new variable is created in the local scope.





```lisp
# Set a as 1
(let a 1)

# Set b as 1
(let b a)


# Global a is access from lower scope
(block
(let a 10)
)

# a is 10 in global scope
(print a)

```

## built-in ##


### list ###

(list {expression} {expression} ...)

Creates and returns a list using given expressions.

A Fuzuli list works like a vector elements and carry many elements from different types.


```lisp
# A list with an integer, a string and a float number
(let mylist (list 1 "orange" 3.141592))

# A list can carry another lists
(let otherlist (list (list 1 2 3) (list 3 4 5)))

# Prints First list's first element: 1
(print (nth (nth otherlist 0) 0) "n")
# Prints First list's second element: 2
(print (nth (nth otherlist 0) 1) "n")
# Prints Second list's third element: 5
(print (nth (nth otherlist 1) 2) "n")



```

## built-in ##


### nth ###

(nth {list-reference} {integer-reference})

Returns (integer-reference)th element of list-reference.
Indices starts from 0 and ends with (number of elements)-1.




```lisp
# A list with an integer, a string and a float number
(let mylist (list 1 "orange" 3.141592))

# A list can carry another lists
(let otherlist (list (list 1 2 3) (list 3 4 5)))

# Prints First list's first element: 1
(print (nth (nth otherlist 0) 0) "n")
# Prints First list's second element: 2
(print (nth (nth otherlist 0) 1) "n")
# Prints Second list's third element: 5
(print (nth (nth otherlist 1) 2) "n")
```

## built-in ##


### params ###







```lisp
```

## built-in ##


### prepend ###

(prepend {list-reference} {reference})

Adds {reference} at the top of the given list {list-reference}. Returns a newly created list as the result. Original list is not modified.



```lisp
# Creating a list
(let a (list 1 2 3))

# Adding 4 at the top of elements
(let a (prepend a 4))

# Printing out the content
(foreach element in a
(print element "n")
)

# Output is
# 4
# 1
# 2
# 3
```

## built-in ##


### print ###







```lisp
```

## built-in ##


### REQUEST ###







```lisp
```

## built-in ##


### require ###

(require {reference})

Loads and runs the given Fuzuli package (nfl).
Fuzuli packages are simply Fuzuli programs. If included package only contains functions, functions are loaded and control is passed to main program.



```lisp
# Loads the io package
(require "/usr/lib/fuzuli/nfl/io.nfl")```

## built-in ##


### return ###

(return {reference})

Returns given reference as a result of a function.




```lisp
# Defining a sum function.
# sum takes a list as parameter and
# returns the sum of contents of this list
(function sum (params x)
(block
(def mysum FLOAT)
(let mysum 0.0)
(foreach element in x
(let mysum (+ mysum element))
)
(return mysum)
)
)

# Creating a list
(let mylist (list 1 5 7 10))

# Calling sum function
(let mysum (sum mylist))

(print mysum "n")
# Result is 23
# An example for two parameter functions
# If there is only one expression in the
# function body, there is no need to use
# a block expression
(function min (params x y)
(if (< x y)
(return x)
(return y)
)
)

# Calling min for 5 and 9
(print (min 5 9) "n")

# Calling min for 67 and 1
(print (min 67 1) "n")


# Output is
# 5
# 1```

## built-in ##


### set ###

(set {array-reference} {integer-reference} {reference}

Set {integer-reference}th element to {reference} of array given by {array-reference}.



```lisp
# Creating a list with elements 1 2 3 and 4
(let a (list 1 2 3 4))

# Setting 4th element to 40
(set a 3 40)

# Printing out the list
(foreach element in a
(print element "n")
)
```

## built-in ##


### setcookie ###







```lisp
```

## built-in ##


### switch ###

(switch x
> (case a (expression1))
> (case b (expression2))
> (case c (expression3))
> ...
)



Switch evaluates expression1 if x equals to a or evaluates expression2 if x equals to b or evaluates expression3 if x equals to c.





```lisp
(let a 2)

(switch a
(case 1
(print "a is 1")
)

(case 2
(print "a is 2")
)

(case 3
(print "a is 3")
)
)

# Result is
# a is 2

```

## built-in ##


### type ###







```lisp
```

## built-in ##


### typeof ###







```lisp
```

## built-in ##


### wait ###







```lisp
```

## built-in ##


### while ###

(while (cond-expression)
> (expression)
> (expression)
> ....
)

While expression is similar to C/C++/Java counterparts. It evaluates expressions sequentially if the given cond-expression is 1.



Condition is an expression that returns 1 or 0 (true or false).

```lisp
# Prints the variable "a" while a is less than 10
(let a 0)
(while (< a 10)
(print a)
(inc a)
)

# Result is
# 123456789




# An example with two conditions
(let a 0)(let b 0)
(while (and (< a 10) (< b 10))
(print a " - " b "n")
)
```

## built-in ##


### | ###

{| {reference} {reference})

Bitwise or operator.



```lisp
# Result is 5
(| 4 5)


# Result is 94
(| 14 88)```

## built-in ##


### **###**

(**{reference} {reference})**

Returns product of given parameters.



```lisp
# Returns 20
(* 4 5)

```

## built-in ##


### inc ###

(inc {reference})

Increments the value of {reference} by 1. Returns NULL.

This function is alias of (++)

```lisp
(let a 10)
(inc a)
# a is 11

(++ a)
# a is now 12```

## built-in ##


### for ###

(for (starter-expression) (cond-expression) (ender-expression)
> (expression)
> (expression)
> ...
)


Performs a \'For\' loop.

start-expression is evaluated once before the loop.

cond-expression is evaluated for every step of iterations. If the condition is 0 (false) then loop ends.

ender-expression is evaluated after each single expression encapsulated by loop was evaluated.




```lisp
# Basic loop
# Basic loop
(let a (list))
(for (let i 0) (<= i 10) (inc i)
(let a (append a (clone i)))
)


(for (let i 0) (<= i 10) (inc i)
(print (nth a i) "n")
)

# Prints
# 0
# 1
# 2
# 3
# 4
# 5
# 6
# 7
# 8
# 9
# 10




###################################################



(let a 0)
(for (let i 0) (< i 3) (inc i)
(for (let j 0) (< j 3) (inc j)
(inc a)
(print a " ")
)
(print "n")
)



# Prints
# 1 2 3
# 4 5 6
# 7 8 9
```

## built-in ##


### setprecision ###

(setprecision {reference})

Sets the internal precision parameter for floating point numbers. The default precision level is 10.



```lisp
(setprecision 5)
(let a 0.12345678901234567890)
# a is 0.12346




(setprecision 10)
(let a 0.12345678901234567890)
# a is 0.123456789


(setprecision 15)
(let a 0.12345678901234567890)
# a is 0.123456789012346


```

## built-in ##


### setepsilon ###

(setepsilon {reference})

Defines the internal epsilon variable for testing the equality of two floating point numbers. In comparisons such as (= a b), if (abs (- a b)) is less than the defined epsilon, then a and b are said to be equal.

The default value is internally 0.00001



```lisp
# Output is 1 (true) because the difference
# between a and b is less than user the defined epsilon.
(setepsilon 0.1)
(let a 0.123)
(let b 0.124)
(print "a equals to b: " (= a b))



# Output is 1 (true) because the difference
# between a and b is less than the user defined epsilon.
(setepsilon 0.01)
(let a 0.123)
(let b 0.124)
(print "a equals to b: " (= a b))



# Output is 0 (false) because the difference
# between a and b is not less than the user defined epsilon.
(setepsilon 0.001)
(let a 0.123)
(let b 0.124)
(print "a equals to b: " (= a b))




```

## built-in ##


### class ###

(class {Identifier} extends {Identifier}
> (block
> > {expression}
> > {expression}
> > ...

> )
)

Defines a class.



```lisp
(class Person extends Object
(block
(def name STRING)

(function setName (params n)
(block
(let name n)
)
)

(function getName (params)
(block
(return name)
)
)
)
)

(let fuzuli (new Person))
(fuzuli.setName "FUZULI")
(print (fuzuli.getName))
```

## built-in ##


### new ###

(new {class-reference}

Creates a new object using a predefined class {class-reference}



```lisp
(class Person extends Object
(block
(def name STRING)

(function setName (params n)
(block
(let name n)
)
)

(function getName (params)
(block
(return name)
)
)
)
)

# Creating an instance of Person
# with name fuzuli
# The function setName is defined in the class Person
# and accessed using the dot operator.
(let fuzuli (new Person))
(fuzuli.setName "FUZULI")
(print (fuzuli.getName))


(let somebody (new Person))
(fuzuli.setName "FUZULI")

```

## built-in ##


### extends ###

Extends is a keyword which is used within a class definition for extending a super class.

Extends inherits a supers class\'s all local variables and functions in a newly created subclass.





```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")
(let passed "PASSED!\n")
(let error "ERROR\n")

(class Person extends Object
(block
(def name STRING)
(def surname STRING)

(function getName (params)
(return name)
)

(function getSurname (params)
(return surname)
)

(function setName (params n)
(let name n)
)

(function setSurname (params s)
(let surname s)
)

(function toString (params)
(return (strcat (list name " " surname)))
)
)
)

(class Student extends Person
(block
(def department STRING)

(function getDepartment (params)
(return department)
)

(function setDepartment (params dep)
(let department dep)
)

(function toString (params)
(return (strcat  (list name " " surname " - " department)))
)
)
)


(let p (new Person))
(p.setName "Fuzuli")
(p.setSurname "Programming Language")

(let s (new Student))
(s.setDepartment "Computer Science")
(s.setName "A Student")
(s.setSurname "A Student's Surname")

(print (p.toString) "\n")
(print (s.toString) "\n")
```

## built-in ##


### remove ###

(remove {list-reference} {reference})

Removes {reference}th element of {list-reference} and returns the remaining part of original list.



```lisp
(let mylist (list "A" "B" "C" "D"))
(let newlist (remove mylist 2))
(print newlist)

# Output is
[A, B, D]
```

## built-in ##


### find ###

(find {list-reference} {reference})

Returns the position of {reference} in {list-reference} if {reference} is contained by {list-reference}, else returns NULL.



```lisp
(let languages (list "C" "C++" "Java" "Perl" "Php"))
(let index (find languages "Visual Basic")
(print index)
# The output is NULL

(let index (find languages "C"))
(print index)
# The output is 0, because C ise the 1st elements of this array.




```

## built-in ##


### fill ###

(fill {array} {element})

Copies the value of {element} to all of the elements of {array}.



```lisp
# Creating an array of 1,2,3,4,5
(let arr (list 1 2 3 4 5))

# Setting each element of arr to 0
(fill arr 0)

# Print array
(print arr)

# The result is: [0, 0, 0, 0, 0]```

## built-in ##


### first ###

(first {array-reference})

Returns the first element of the given list.



```lisp
# Creating list
(let arr (list -10 45 5 6))

# Getting first element
(let f (first arr))

# Getting last element
(let l (last arr))

# Print
(print "First is : " f "\n")
(print "Last is  : " l "\n")
```

## built-in ##


### last ###

(last {list-reference})

Returns the last element of the given list.



```lisp
# Creating list
(let arr (list -10 45 5 6))

# Getting first element
(let f (first arr))

# Getting last element
(let l (last arr))

# Print
(print "First is : " f "\n")
(print "Last is  : " l "\n")
```

## built-in ##


### expression ###

(expression code)

expression handles the generated abstract syntax tree from the code. Code is not being run. (eval) function can be used for evaluating the handled AST encapsulated by expression.



```lisp
# myexp handles the AST (Abstract Syntax Tree)
# but does not run the code. There is output
(let myexp
(expression
(print "Hello World!\n")
)
)

# Calling eval function on myexp
# triggers the expression. (Evaluates it)
(eval myexp)

# The result is:
# Hello World!
```

## built-in ##


### timing ###

(timing {expression} {expression} ... )

Calculates total processing times of given expressions by means of milliseconds.



```lisp
(let passed "PASSED!\n")
(let error "ERROR\n")


# Creating an array from 0 to 100000 takes
# t1 milliseconds in total.
(let t1 (timing

(let b (: 0 100000))

))


# Creating an array from 0 to 200000 takes
# t2 milliseconds in total. We expect that
# t2 is nearly two times bigger than t1.
(let t2 (timing

(let c (: 0 200000))
))


# Calculation the ratio of t2 / t1
(let result (/ t2 t1))
(if (and (>= result 2) (<= result 3))
(print passed)
(print error)
)

# We got a message of PASSED! because t2 / t1 ratio
# is neary 2```

## io ##


### fopen ###







```lisp
```

## io ##


### fclose ###

(fclose {file-reference})

Closes the stream referenced by file-reference.



```lisp
(let file (fopen "filename" "w"))
(fputs file "something written in the file")
(fclose file)
```

## io ##


### feof ###

(feof {file-reference})

Returns 1 if the current position of file cursor is at the end of the file-reference, else returns 0.




```lisp
(let file (fopen "afile.txt" "r"))
(while (feof file)
(print (fgetc file))
)
(fclose file)
```

## io ##


### fwrite ###







```lisp
#!/usr/lib/fuzuli/fuzuli
(print "Content-type: text/htmlnn")

(require "/usr/lib/fuzuli/nfl/io.nfl")

<?html
<title>FWRITE

Unknown end tag for &lt;/title&gt;


?>

<?html
<form method="get">
<input type="text" name="value">
<input type="submit">
?>

(let myContent (REQUEST "value"))
#touch a file which's name content.txt
(let myFile (fopen "content.txt" "w"))
(fwrite myFile myContent)
(fclose myFile)

<?html


Unknown end tag for &lt;/form&gt;


?>```

## io ##


### fread ###







```lisp
```

## io ##


### fflush ###

(fflush {file-reference})

Empties the file buffer.



```lisp
(let file (fopen "file.txt" "w"))
(fputs file "Hello")
(fflush file)
(fclose file)
```

## io ##


### chdir ###

(chdir {dir-reference})

Changes directory.



```lisp
(chdir "/tmp")
```

## io ##


### getpwd ###

(getpwd)

Returns name of current working directory as string.



```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")
(let cdir (getpwd))
(print "Current directory is: " cdir)

```

## io ##


### dir ###







```lisp
```

## io ##


### unlink ###

(unlink {file-reference})

Deletes the file given in the file-reference.



```lisp
(unlink "/tmp/1.txt")
```

## io ##


### rename ###

(rename {reference1} {reference2})

Renames the file given in the reference1 with reference2.



```lisp
(rename "/tmp/1.txt" "/tmp/2.txt")
```

## io ##


### tmpfile ###







```lisp
```

## io ##


### tmpnam ###

(tmpname)

Returns a temporary file name.



```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

# Getting a temporary file name
(let filename (tmpnam))

(print "Writing string to " filename "n")

# Opening temporary file
(let file (fopen filename "w"))

# Writing file content
(fputs file "Hello world!")

# Closing file
(fclose file)


(print "Finn")

```

## io ##


### datetime ###







```lisp
```

## io ##


### asctime ###







```lisp
```

## io ##


### sleep ###







```lisp
```

## io ##


### getenv ###

(getenv {reference})

Returns the value of the environmental variable given with reference.



```lisp
(let path (getenv "PATH"))
```

## io ##


### rnd ###

(rnd)

Returns a pseudo random number from a uniform distribution with parameters 0 and 1.

This function produces the same random numbers in each start but randomize function can be used to change start point.





```lisp
(randomize time)

# Random number between 0 and 1
(let a (rnd))


# Random number between 0 and 100
(let a (* 100 (rnd)))

# Random number between 100 and 200
(let a (+ 100 (* 100 (rnd))))




```

## io ##


### print\_r ###







```lisp
```

## io ##


### popen ###







```lisp
```

## io ##


### pclose ###







```lisp
```

## io ##


### is\_dir ###

(is\_dir {reference})

Return 1 if the given string reference points to a directory, else returns 0




```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

(let result (is_dir "/home"))
(print result)
# Result is 1


(let result (is_dir "/home/fuzuli/1.txt"))
(print result)
# Result is 0
```

## io ##


### time ###

(time)

Returns the system time in integer.



```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

# Prints current time in integer format
(let current_time (time))
(print "Time is: " current_time "n")


# Set seed of random number generator to time
(randomize current_time)
(let number (rnd))
(print "Generated random number: " number "n")



```

## io ##


### randomize ###

(randomize {reference})

Set seed of the random number generator.

If the given reference is an integer constant, random number generator will always generate same pseudo random numbers.

Setting the seed to system time is a good practice to generate new random numbers.

```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")


# Set seed of random number generator to time
(randomize (time))
(let number (rnd))
(print "Generated random number: " number "n")






```

## io ##


### fputs ###

(fputs {file-reference} {reference}

Writes string content of reference into the file with referenced by file-reference.




```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

(let file (fopen "/tmp/hellofromfuzuli.txt" "w"))
(fputs file "Hello fuzuli!")
(fclose file)

```

## io ##


### puts ###

(puts {reference})

Prints the string content of reference in standard output.




```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

(puts "Hello world!")
```

## io ##


### fgetc ###

(fgetc {file-reference})

Reads and returns a character from given file reference.




```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

# Writing Hello world! to text file
(let file (fopen "/tmp/hellofromfuzuli.txt" "w"))
(fputs file "Hello world!")
(fclose file)


# Reading characters while not reached end of file
(let file (fopen "/tmp/hellofromfuzuli.txt" "r"))
(while (not (feof file))
(print (fgetc file))
)
(fclose file)


# Reads a character from standard input
(let file (fopen "stdin" "r"))
(print (fgetc file))
(fclose file)

```

## io ##


### ftell ###

(ftell {file-reference})

Returns the position of the cursor of the given file reference.



```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")

(let file (fopen "/tmp/hellofromfuzuli.txt" "w"))
(fputs file "Hello world!")
(fclose file)


(let file (fopen "/tmp/hellofromfuzuli.txt" "r"))
(while (not (feof file))
(print (fgetc file) "[" (ftell file) "]n")
)
(fclose file)

# Output
# H[1]
# e[2]
# l[3]
# l[4]
# o[5]
#  [6]
# w[7]
# o[8]
# r[9]
# l[10]
# d[11]
# ![12]
# ï¿½[12]```

## io ##


### readline ###

(readline)

Reads a line from console and returns the captured data as string.



```lisp
(require "/usr/lib/fuzuli/nfl/io.nfl")
(print "Enter name: ")
(let name (readline))
(print "You entered " name "n")```

## mysql ##


### mysql\_connect ###

(mysql\_connect {host} {user} {pass} {db} {port})

Returns a connection to a mysql server on machine {host} and port {port}. {user} and {pass} is used for authentication. Selected database is given in {db}



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "Doga" "******" "FzlDocs" 3306))

# con holds a connection to server localhost.```

## mysql ##


### mysql\_query ###

(mysql\_query {conn} {sql})

Returns a resultset after executing {sql} on connection {conn}



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_query con "select * from Report"))

(while 1
(let row (mysql_fetch_array result))
(if (= (length row) 0) (break))
(foreach element in row
(print element " - ")
)
(print "n")
)

(mysql_close con)
```

## mysql ##


### mysql\_fetch\_array ###

(mysql\_fetch\_array {result})

Returns the next row as list using the resultset {result}.

If returned list has a size of zero then there is no rows available for reading.





```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_query con "select * from Report"))

(while 1
(let row (mysql_fetch_array result))
(if (= (length row) 0) (break))
(foreach element in row
(print element " - ")
)
(print "n")
)

(mysql_close con)
```

## mysql ##


### mysql\_num\_fields ###

(mysql\_num\_fields {result})

Returns number of fields in resultset {result}



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_query con "select * from Report"))

(print "Number of Fields: " (mysql_num_fields result) "n")

(mysql_close con)
```

## mysql ##


### mysql\_num\_rows ###

(mysql\_num\_rows {result})

Returns number of rows for given resultset {result}



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_query con "select * from Report"))

(print "Number of rows: " (mysql_num_rows result) "n")

(mysql_close con)
```

## mysql ##


### mysql\_affected\_rows ###

(mysql\_affected\_rows {con})

Returns number of affected rows after an update or insert operation on a connection given by {con}.




```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_query con "select * from Report"))

(let rows (mysql_affected_rows con))

(print rows " rows recorded.n")

(mysql_close con)```

## mysql ##


### mysql\_get\_client\_info ###

(mysql\_get\_client\_info)

Returns a string description of mysql client used in Fuzuli.



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(print (mysql_get_client_info))

(mysql_close con)

# Output is
# Client info : 5.5.22```

## mysql ##


### mysql\_close ###

(mysql\_close {con})

Close the connection given by {con}.



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(mysql_close con)
```

## mysql ##


### mysql\_result ###

(mysql\_result {result} {row} {col})

Returns the value of data field in row {row} and column {col} from resultset {result}.






```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))


(let result (mysql_query con "select count(*) from Report"))


# Read resultset from row 0 and column 0
(let result (mysql_result result 0 0))

(print "Number of rows: " result "n")

(mysql_close con)```

## mysql ##


### mysql\_character\_set\_name ###

(mysql\_character\_set\_name {con})

Returns the current character set name for given connection by {con}



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let chset (mysql_character_set_name con))

(print "Character set is: " chset "n")

(mysql_close con)

```

## mysql ##


### mysql\_select\_db ###

(mysql\_select\_db {con} {reference})

Set active database to {reference} for connection {con}.
If the process is succeed, returns 0.



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_select_db con "mysql"))
(print result "n")

(mysql_close con)```

## mysql ##


### mysql\_stat ###

(mysql\_stat {con})

Returns some information about the connection given by {con}



```lisp
(require "/usr/lib/fuzuli/nfl/mysql.nfl")

(let con (mysql_connect "localhost" "fuzuli" "*****" "SampleDB" 3306))

(let result (mysql_stat con))
(print result "n")


(mysql_close con)


# Output is possibly
# Uptime: 27870 Threads: 1 Questions: 115
# Slow queries: 0 Opens: 183 Flush tables: 1
# Open tables: 44 Queries per second avg: 0.004```

## mysql ##


### mysql\_autocommit ###

(mysql\_autocommit {con} {reference})

Sets auto commit option to 1 (true) or 0 (false).
Return zero if the process is succeed.





```lisp
# Autocommit is active

(let result (mysql_autocommit con 1))

```

## net ##


### fsockopen ###

(fsockopen {host} {port})

Opena and returns a TCP socket handle to {host} on {port}.



```lisp
# This example opens a connection to fuzuliproject.org and gets the page content.

(require "/usr/lib/fuzuli/nfl/net.nfl")
(require "/usr/lib/fuzuli/nfl/string.nfl")
(require "/usr/lib/fuzuli/nfl/io.nfl")

# Opening connection on port 80
(let con (fsockopen "fuzuliproject.org" 80))

# Sending Http request
(fsockwrite con "GET http://www.fuzuliproject.org/index.phpnn")

(def html STRING)
(def content LIST)

# Reading a byte each time
# This number would be a bigger integer.
(let content (list "."))
(while 1
(block
(let html (fsockread con 1)) #read 1 bytes
(if (= (typeof html) NULL) (break))
(append content html)
)
)
(fsockclose con)

```

## net ##


### fsockread ###

(fsockread {socket-reference} {reference})

Retrieves number of {reference} bytes from the socket given by {socket-reference}.



```lisp
#
# fuzuli : A general purpose interpreter
# Copyright (C) 2012 Mehmet Hakan Satman <mhsatman@yahoo.com>
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

(require "nfl/io.nfl")
(require "nfl/string.nfl")
(require "nfl/net.nfl")

(puts "Please give a domain (for default just type enter):")
(let word (readline))

(if (< (strlen word) 3)
(let word "amazon.com")
)
(print "Doing " word "n")


(print "Connecting " word "n")
(let socket (fsockopen word 80))

(print "Sending requestn")
(fsockwrite socket (strcat (list "GET /nn")))

(print "Retrieving resultn")
(def htmllist LIST)
(while 1
(let c (fsockread socket 1))
(if (= (typeof c) NULL) (break))
(append htmllist c)
)
(fsockclose socket)

(print "Constucting stringn")

(let html (strcat htmllist))
(let len (strlen html))
(print len " bytes read.n")

(def part STRING)
(def i INTEGER)

(for (let i 0) (< i len) (inc i)
(let part (substr html i (+ i 7)))
(if (= part "<a href")
(block
(print "link found: n")
(while (!= part "

Unknown end tag for &lt;/a&gt;

")
(let part (substr html i (+ i 4)))
(print (substr html i (+ i 1)))
(inc i)
)
(print part "n")
)
)
)(require "nfl/net.nfl")
(require "nfl/string.nfl")
(require "nfl/io.nfl")

(print "Opening connection to fuzuliproject.org:80n")
(let con (fsockopen "fuzuliproject.org" 80))
(print "Sending Requestn")
(fsockwrite con "GET http://www.fuzuliproject.org/index.phpnn")

(def html STRING)
(def content LIST)

(print "Reading contentn")
(let content (list "."))
(while 1
(block
(let html (fsockread con 1)) #read 1 bytes
(if (= (typeof html) NULL) (break))
(append content html)
)
)
(print "Testing: ")
(fsockclose con)
(let strcontent (strcat content))
(if (> (instr strcontent "Practical") 0)
(print "PASSED!n")
(print "ERRORn")
)

```

## net ##


### fsockwrite ###

(fsockwrite {socket-reference} {reference}

Send the data given by {reference} throughout the socket {socket-reference}.



```lisp
#
# fuzuli : A general purpose interpreter
# Copyright (C) 2012 Mehmet Hakan Satman <mhsatman@yahoo.com>
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

(require "nfl/io.nfl")
(require "nfl/string.nfl")
(require "nfl/net.nfl")

(puts "Please give a domain (for default just type enter):")
(let word (readline))

(if (< (strlen word) 3)
(let word "amazon.com")
)
(print "Doing " word "n")


(print "Connecting " word "n")
(let socket (fsockopen word 80))

(print "Sending requestn")
(fsockwrite socket (strcat (list "GET /nn")))

(print "Retrieving resultn")
(def htmllist LIST)
(while 1
(let c (fsockread socket 1))
(if (= (typeof c) NULL) (break))
(append htmllist c)
)
(fsockclose socket)

(print "Constucting stringn")

(let html (strcat htmllist))
(let len (strlen html))
(print len " bytes read.n")

(def part STRING)
(def i INTEGER)

(for (let i 0) (< i len) (inc i)
(let part (substr html i (+ i 7)))
(if (= part "<a href")
(block
(print "link found: n")
(while (!= part "

Unknown end tag for &lt;/a&gt;

")
(let part (substr html i (+ i 4)))
(print (substr html i (+ i 1)))
(inc i)
)
(print part "n")
)
)
)
```

## net ##


### fsockclose ###

(fsockclose {socket-reference}

Closes the socket given by {socket-reference}




```lisp
(require "nfl/net.nfl")
(require "nfl/string.nfl")
(require "nfl/io.nfl")

(print "Opening connection to fuzuliproject.org:80n")
(let con (fsockopen "fuzuliproject.org" 80))
(print "Sending Requestn")
(fsockwrite con "GET http://www.fuzuliproject.org/index.phpnn")

(def html STRING)
(def content LIST)

(print "Reading contentn")
(let content (list "."))
(while 1
(block
(let html (fsockread con 1)) #read 1 bytes
(if (= (typeof html) NULL) (break))
(append content html)
)
)

# Closing socket
(fsockclose con)

(print "Testing: ")

(let strcontent (strcat content))
(if (> (instr strcontent "Practical") 0)
(print "PASSED!n")
(print "ERRORn")
)

```

## net ##


### fsocklisten ###

(fsocklisten {port-reference}

Listens and accepts tcp connections for the given port {port-reference}. Returns a new socket whenever it establish a new connection.



```lisp
# Listen port 80
(let serversocket (fsocklisten 80))```

## string ##


### strlen ###

(strlen {reference})

Returns number of characters of a given string.



```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")
(let aStr "Hello")
(print (strlen aStr))
#returns 5
```

## string ##


### trim ###

(trim {reference})

Removes spaces from left and right for a given string.



```lisp
# returns fuzuli without spaces
(print (trim "   fuzuli    "))```

## string ##


### ltrim ###

(ltrim {reference})

Removes spaces from left for a given string.



```lisp
# Returns "fuzuli   "
(let a (ltrim "   fuzuli   "))
(print a)
```

## string ##


### rtrim ###

(rtrim {reference})

Removes spaces from right for a given string



```lisp
# Returns "   fuzuli"
(let a (rtrim "   fuzuli   "))
(print a)
```

## string ##


### lcase ###

(lcase {reference})

Returns a new string with given string in lower case letters.



```lisp
# Returns fuzuli
(let a (lcase "FUZULI"))
```

## string ##


### ucase ###

(ucase {reference})

Returns new string with given string in upper case letters.



```lisp
#Returns FUZULI
(let a (ucase "fuzuli"))
```

## string ##


### left ###

(left {reference} {reference})

Returns a new string with first X letters from the given string



```lisp
# Returns Fri
(let a (left "Friday" 3))
(print a)

# Returns F
(let a (left (left "Friday" 3) 1))
(print a)
```

## string ##


### right ###

(left {reference} {reference})

Returns a new string with last X letters from the given string



```lisp
# Returns day
(let a (right "Friday" 3))
(print a)

# Returns y
(let a (right (right "Friday" 3) 1))
(print a)```

## string ##


### strcat ###

(strcat {listreference})

Concatenate strings in a given list



```lisp
(let mylist (list "first" "second" "third"))
(let str (strcat mylist))
(print str)

# Result is fistsecondthird```

## string ##


### substr ###

(substr {reference} {reference} {reference})

(substr str x y) returns characters between the indices x and y from string str.



```lisp
(let str "Fuzuli Programming Language")
(let part (substr str 7 18))
(print part)

#Returns Programming
```

## string ##


### strreverse ###

(strreverse {reference})

Returns reverse of a given string



```lisp
(let str "istanbul")
(let inverse (strreverse str))
(print inverse)

#returns lubnatsi
```

## string ##


### instr ###

(instr {string reference} {string reference})

Returns a positive integer if a string is included in the other one.

If second string is not included in the bigger one, returns zero.

Returned integer indicates the first occurrence of the string part in main string.



```lisp
# returns the index of first occurrence of "uzu" in "fuzuli". The result is 1
(instr "fuzuli" "uzu")


# this example returns zero
(instr "fuzuli" "abc")

```

## string ##


### chr ###

(chr {reference})

Returns the character correspoing to the given ascii code from 0 to 255



```lisp
# Makes an ascii table
(require "usr/lib/fuzuli/nfl/string.nfl")
(for (let i 0) (< i 256) (inc i)
(print i ") " (chr i) "n")
)
```

## string ##


### md5 ###

(md5 {reference})

Returns md5 for a given string.



```lisp
(let crypt (md5 "fuzuli"))
(print crypt)

# Result is ac7f77c9a8a84e110342dd8117b54af1



```

## string ##


### urldecode ###

(urldecode {reference})

Returns the decoded form of a given URL.



```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

(print (urldecode "/?name=a%20b+c"))

# Result is /?name=a b c```

## string ##


### levenshtein ###

(levenshtein {reference1} {reference2})

Returns the levenshtein distance between two given string references.



```lisp
# Returns 12
(let result17 (levenshtein "fuzuli" "the fuzuli project"))

# Returns 0
(let result17 (levenshtein "fuzuli" "fuzuli"))



(require "/usr/lib/fuzuli/nfl/string.nfl")

(function nearest (params alist x)
(block
(def mindist INTEGER)
(def bestone STRING)
(let mindist (strlen x))
(foreach element in alist
(block
(let l (levenshtein element x))
(if (< l mindist)
(block
(let mindist l)
(let bestone element)
)
)
)
)
(return bestone)
)
)

(let mylist (list "sunday" "monday" "saturday" "friday"))
(print "Nearest word to freeday is: " (nearest mylist "freeday") "n")
```

## string ##


### ord ###

(ord {reference})

Returns the ascii code (integer) of a given character.



```lisp
(print (ord "A") "n")
# Returns ascii code of A, 65.


#This example returns the ascii code of characters in string "fuzuli"
(let str "fuzuli")
(for (let i 0) (< i (strlen str)) (inc i)
(block
(let char (substr str i (+ i 1)))
(print char ": " (ord char) "n")
)
)
#Result is:
#f: 102
#u: 117
#z: 122
#u: 117
#l: 108
#i: 105
```

## string ##


### str\_replace ###

(str\_replace {reference} {reference} {reference})

(str\_replace a b c) replaces b with c in a.



```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

# This example replaces Fuzuli with Fuzuli Programming Language
(let str "Writing with Fuzuli is fun!")
(let newstr (str_replace str "Fuzuli" "Fuzuli Programming Language"))
(print newstr "n")
# Result is Writing with Fuzuli Programming Language is fun!




(let str "Hello hello hello world!")
(let newstr (str_replace str "hello " ""))
(print newstr "n")
# Result is Hello world!```

## string ##


### str\_shuffle ###

(str\_shuffle {reference})

Shuffles a string.



```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

(let str "fuzuli")
(let newstr (str_shuffle str))
(print newstr "n")
# Returns uzlifu```

## string ##


### isdigit ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})


isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.




All functions described here are take only one reference in string type with 1 character.


```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0```

## string ##


### isalpha ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})



isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.

All functions described here are take only one reference in string type with 1 character.

```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### isalnum ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})


isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.


All functions described here are take only one reference in string type with 1 character.


```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### isupper ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})




isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.


All functions described here are take only one reference in string type with 1 character.


```lisp

(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### islower ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})


isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.




All functions described here are take only one reference in string type with 1 character.




```lisp

(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### iscntl ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})


isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.



All functions described here are take only one reference in string type with 1 character.




```lisp
(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0```

## string ##


### isgraph ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})


isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.

All functions described here are take only one reference in string type with 1 character.




```lisp

(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### isprint ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})


isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.


All functions described here are take only one reference in string type with 1 character.




```lisp


(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### ispunct ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})



isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.




All functions described here are take only one reference in string type with 1 character.



```lisp


(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## string ##


### isspace ###

(isdigit {reference})
(isalpha {reference})
(isalnum {reference})
(isupper {reference})
(islower {reference})
(iscntl {reference})
(isgraph {reference})
(isprint {reference})
(ispunct {reference})
(isspace {reference})




isdigit returns 1 if the given reference is digit, else returns 0.

isalpha returns 1 if the given reference is letter, else returns 0.

isalnum returns 1 if the given reference is either digit or letter, else returns 0.

isupper returns 1 if the given reference is in upper case, else returns 0.

islower returns 1 if the given reference is in lower case, else returns 0.

iscntl returns 1 if the given reference is a control character like enter and tab, else returns 0.

isgraph returns 1 if the given reference is graph, else returns 0.

isprint returns 1 if the given reference is printable, else returns 0.

ispunct returns 1 if the given reference is a punctuation character, else returns 0.

isspace returns 1 if the given reference is space, else returns 0.




All functions described here are take only one reference in string type with 1 character.




```lisp


(require "/usr/lib/fuzuli/nfl/string.nfl")

(print "1 is digit: " (isdigit "1") "n")
(print "A is digit: " (isdigit "A") "n")

(print "1 is alpha: " (isalpha "1") "n")
(print "A is alpha: " (isalpha "A") "n")

(print "A is alphanumeric: " (isalnum "A") "n")
(print "1 is alphanumeric: " (isalnum "1") "n")
(print "= is alphanumeric: " (isalnum "=") "n")

(print "A is upper: " (isupper "A") "n")
(print "a is upper: " (isupper "a") "n")

(print "A is lower: " (islower "A") "n")
(print "a is lower: " (islower "a") "n")

(print "Enter is cntrl: " (iscntrl "n") "n")
(print "a is cntrl: " (iscntrl "a") "n")

(print "chr(255) is showable: " (isgraph (chr 255)) "n")
(print "a is showable: " (isgraph "a") "n")

(print "chr(255) is printable: " (isprint (chr 255)) "n")
(print "a is printable: " (isprint "a") "n")

(print "! is punct: " (ispunct "!") "n")
(print "a is punct: " (ispunct "a") "n")

(print "  is space: " (isspace " ") "n")
(print "a is space: " (isspace "a") "n")


# The output is
# 1 is digit: 1
# A is digit: 0
# 1 is alpha: 0
# A is alpha: 1
# A is alphanumeric: 1
# 1 is alphanumeric: 1
# = is alphanumeric: 0
# A is upper: 1
# a is upper: 0
# A is lower: 0
# a is lower: 1
# Enter is cntrl: 1
# a is cntrl: 0
# chr(255) is showable: 0
# a is showable: 1
# chr(255) is printable: 0
# a is printable: 1
# ! is punct: 1
# a is punct: 0
#   is space: 1
# a is space: 0
```

## math ##


### acos ###

(acos {reference})

Return arc-cosine of the given reference.



```lisp
# Returns 0
(acos 1.0)```

## math ##


### atan ###

(atan {reference})

Returns arc-tangent of the given reference.




```lisp
# Returns 1.10715
(atan 2)```

## math ##


### PI ###

PI

Returns a short representation of PI



```lisp
# output: 3.14159
(print PI)

```

## math ##


### sin ###

(sin {reference})

Returns sine of given reference.



```lisp
# Returns 1
(sin (/ PI 2.0))
```

## math ##


### cos ###

(cos {reference})

Returns cosine of given reference.



```lisp
# Returns -1
(cos PI)```

## math ##


### tan ###

(tan {reference})

Returns tangent of given reference



```lisp
# Returns 0
(tan 0)
```

## math ##


### abs ###

(abs {reference})

Returns the absolute value of given reference.




```lisp
# Output is 1
(print (abs -1))

# Output is 1
(print (abs 1))

```

## math ##


### sqrt ###

(sqrt {reference})

Returns square root of given reference.




```lisp
# Returns 5
(sqrt 25)



# Output is 10
(print (sqrt 100))
```

## math ##


### exp ###

(exp {reference})

Returns E^reference where E is the Euler\'s number.



```lisp
# Returns 1
(exp 0)

# Return 2.71828
(exp 1)
```

## math ##


### log ###

(log {reference})

Returns natural logarithm of given reference.



```lisp
# Returns 0
(log 1)

# Returns 0.999999, which is almost 1
(log 2.71828)


```

## math ##


### log10 ###

(log10 {reference})

Returns the logarithm of reference with base 10.




```lisp
# Returns 2
(log10 100)

# Returns 5
(log10 (pow 10 5))
```

## math ##


### log2 ###

(log2 {reference})

Returns the logarithm of reference with base 2.



```lisp
# Returns 1
(log2 2)

# Returns 5
(log2 (pow 2 5))
```

## math ##


### cosh ###

(cosh {reference})

Returns hyperbolic cosine of given reference.



```lisp
# Returns 1
(cosh 0)```

## math ##


### sinh ###

(sinh {reference})

Returns hyperbolic sine of given reference.




```lisp
# Returns 0
(sinh 0)
```

## math ##


### tanh ###

(tanh {reference})

Returns hyperbolic tangent of given reference.



```lisp
# Returns 0
(tanh 0)
```

## math ##


### asin ###

(asin {reference})

Returns arc sine of given reference.



```lisp
# Returns approximately PI / 2
(asin 0)
```

## math ##


### pow ###

(pow {reference1} {reference2})

Returns reference1 ^ reference2



```lisp
# Returns 25
(pow 5 2)

# Returns 1000
(pow 10 3)

```

## math ##


### ceil ###

(ceil {reference})

Returns a new number with rounding fractions of given reference up.



```lisp
# Returns 3
(ceil 2.1)

# Returns 3
(ceil 2.5)

# Returns 3
(ceil 2.9)
```

## math ##


### floor ###

(floor {reference})

Returns a new number with rounding fractions of given reference down.



```lisp
# Returns 2
(floor 2.1)

# Returns 2
(floor 2.5)

# Returns 2
(floor 2.9)

```

## math ##


### round ###

(round {reference})

Returns the rounded number given with reference.



```lisp
# Returns 2
(round 2.1)

# Returns 3
(round 2.5)

# Returns 3
(round 2.9)
```

## math ##


### atan2 ###

(atan2 {reference1} {reference2})

Calculates and returns two-arguments arc tangent function from reference1 and reference2.




```lisp
# Returns 0.785398
(atan2 1 1)
```

## math ##


### isinf ###

(isinf {reference})

Returns 1 if the given reference either positive or negative infinity, else returns 0.



```lisp
# Returns 1
(isinf (/ 1 0))```

## utils ##


### shuffle ###







```lisp
```

## utils ##


### sort ###







```lisp
```

## thread ##


### thread ###

(thread {function\_name})

Creates and returns a thread for a given function name.




```lisp
(require "/usr/lib/fuzuli/nfl/thread.nfl")

(function f (params)
(block
(print "F started\n")
(foreach i in (: 1 10)
(print "f\n")
(thread_yield)
(thread_sleep 100)
)
(return 0)
)
)

(function g (params)
(block
(print "G started\n")
(foreach i in (: 1 10)
(print "g\n")
(thread_yield)
(thread_sleep 100)
)
(return 0)
)
)

(function h (params)
(block
(print "H started\n")
(foreach i in (: 1 10)
(print "h\n")
(thread_yield)
(thread_sleep 100)
)
(return 0)
)
)

(let t0 (thread "f"))
(let t1 (thread "h"))
(let t2 (thread "g"))

(thread_join t0)


```

## thread ##


### thread\_join ###







```lisp
```

## thread ##


### thread\_sleep ###







```lisp
```

## thread ##


### thread\_yield ###







```lisp
```