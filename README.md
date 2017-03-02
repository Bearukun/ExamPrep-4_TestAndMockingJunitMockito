# ExamPrep-4_TestAndMockingJunitMockito
Part of the SP4 hand-in (Computer Science)

###Q: Explain fundamental topics related to software testing like "test first" vs. "test after"

A: As the question mentions, there are two different approaches to developing software. 

“Test first” will give you a good overview of what kind of functionality and output you want from the methods you need to implement. This approach will make you develop your system around the test. 

“Test after” will be faster for some people, but may lead to code with more bugs than excepted with a “final build” compared to the “Test first” method. This is because there will not be a clear overview of what the functions should do, and what they should not do. 

###Q: Explain the basics of writing JUnit-tests

A: JUnit is a unit testing framework for Java programming language. JUnit has been important in the development of test-driven development, and is one of a family of unit testing frameworks collectively known as xUnit, that originated with JUnit.

A Unit Test Case is a part of code, which ensures that another part of code (method) works as expected. To achieve the desired results quickly, a test framework is required. JUnit is a perfect unit test framework for Java programming language.

The Assert Class is used to run tests against your programs methods, a broad variety of assertion methods is available: 

1

void assertEquals(boolean expected, boolean actual)

Checks that two primitives/objects are equal.


2

void assertFalse(boolean condition)

Checks that a condition is false.


3

void assertNotNull(Object object)

Checks that an object isn't null.


4

void assertNull(Object object)

Checks that an object is null.


5

void assertTrue(boolean condition)

Checks that a condition is true.


6

void fail()

Fails a test with no message.

###Q Explain about strategies/frameworks to unit test code, with complex dependencies

A: Our semester is using the Mockito framework. Using mockito, you can verify what you want. Using expect-run-verify libraries you are often forced to look after irrelevant interactions.
No expect-run-verify also means that Mockito mocks are often ready without expensive setup upfront. They aim to be transparent and let the developer to focus on testing selected behavior rather than absorb attention.
Mockito has very slim API, almost no time is needed to start mocking. There is only one kind of mock, there is only one way of creating mocks. Just remember that stubbing goes before execution, verifications of interactions go afterwards. You'll soon notice how natural is that kind of mocking when TDD-ing java code.

###Q Explain the topics: State Verification vs Behaviour Verification and relate to examples i the code

A:

###Q Explain why testers “just love” the Dependency Injection Pattern

A: When using the Dependency Injection Pattern, you can make use of Mock objects. A mock object is a dummy implementation for an interface or a class in which you define the output of certain method calls. This is smart, since you do not need a working class - or if you want to control the output of a function if you want to test a special part of your system. 





