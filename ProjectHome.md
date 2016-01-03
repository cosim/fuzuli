2015.03.21  -  We moved our repository to github. By now on, any contributions to Fuzuli and its sub-projects will be pushed in the repository https://github.com/jbytecode/fuzuli
Please follow the project in github.

Blog entries in our blog still remain.

Please follow the link

http://stdioe.blogspot.com.tr/search/label/jfuzuli

and

http://stdioe.blogspot.com.tr/search/label/fuzuli

for news and code snippets.





```lisp

(function fibonacci (params x)
(block
(if (<= x 2)
(return 1)
(return (+ (fibonacci (- x 1)) (fibonacci (- x 2))))
)
)
)
```
Fuzuli is a new programming language and interpreter. Fuzuli has its name from 16th century Ottoman poet Fuzuli (Muhammad bin Suleyman).
Fuzuli has an interesting word in Arabic language. It means impertinent, improper and unnecessary in English. Fuzuli used this word because he thought that nobody else could take it as a pen name.

We also chose this name for our interpreter because we don't really need it! There are lots of programming languages such as C, C++, Java, Php and Perl that we use in our projects and we are not really sure that humanity needs another one.

But it is true that we had fun while we were working on it!

Fuzuli has a syntax similar to Lisp but it is not intended to be an other Lisp clone. It has got several properties inhereted from Algol family and others. For example; syntax of while and foreach statements were directly derived from C++ and R, respectively. Some string manipulation functions share the same names and definitions from Visual Basic. Math and IO libraries are like C++ standard library and MySql library uses libmysql directly.

So, any programmer from any languages are just ready to test and use Fuzuli. It's neither a Lisp nor an Algol but it is a combination of what we have ever used.

Note that, it is in early stages and it needs to be tested and used. If you like Fuzuli and have skills of C++ or Fuzuli, just join us.

Fuzuli is distributed with GPL license and hosted in Google Code ( http://code.google.com/p/fuzuli ). It initially has deb and lzm packages for Debian-Ubuntu and Slax distros, respectively.

Internally, Fuzuli's syntax is like Lisp's syntax but we didn't implement a Lisp machine. Instead of using stacks, we construct an abstract syntax tree and trigger just a one eval method. Interpretion of language is similar to other syntaxed languages.

Fuzuli also has a primitive garbage collection utility. This ability is bounded and open for further development. But it has a nice variable scoping logic which is difficult for Lisp learners in Lisp.

Finally, we are not waiting anything from the community and we just want to share what we do for fun. We hope you have fun and enjoy Fuzuli... Anyway, working with Fuzuli is just a fuzuli work!

For the Fuzuli Development Team, jbytecode







For more information and language reference, visit our Wiki pages.

Fuzuli was first introduced in site [Practical Code Solutions](http://stdioe.blogspot.com/2012/05/fuzuli-new-general-purpose-interpreter.html).

Official web site [Fuzuli Project](http://www.fuzuliproject.org).



