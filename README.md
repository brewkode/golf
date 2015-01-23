Golf
====

This project aims to generate regexes from known set of samples provided as inputs. This is not exactly what Regex golf
problem is expected to do. For the uninitiated, regex golf expects the user to come up with a regex that matches a set 
of words in the allowed list and shouldn't match the set of words in the disallowed list. And, there's some interesting
attempts to see if it's possible for a computer to solve this problem.
 
Back to our problem, generating "optimal(shorter/efficient)" regexes for known set of samples is an interesting research area and 
there's some good work of academic work that has gone into it. There are strong use-cases for this from Gene sequencing 
to entity recognition to other streams of work. 

More often than not, the goal of a system like this would be to help with data analysis and reducing the amount of 
manual effort that might be needed to create regex(as rules) to help build bigger learning systems.

Plan of Attack
==============

The first version of this is expected to produce naive regex that are limited and specific to inputs that the 
algorithm sees. So, if we want to generalize this across various patterns, it's the responsibility of the consumer to 
give this system input that covers various patterns.


- will generalize repeating substring using * or +
- wont nest sub-components that have *s. What this means is, we would have expressions whose star-height is only 1.


Roadmap
=======

- Support star-height of K
- Support regex hints along with the input set
 - ability to generalize the specific regex using char classes or other known custom patterns(like date pattern, time pattern, etc).
 
 
Reference
=========

- Algorithms for Learning Regular expression using positive data, Henning Fernau

