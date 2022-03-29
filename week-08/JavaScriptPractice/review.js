// let value;
// console.log(typeof value); // undefined
// value = 25;
// console.log(typeof value); // number
// value = "Hodgepodge";
// console.log(typeof value); // string
// value = true;
// console.log(typeof value); // boolean
// value = {};
// console.log(typeof value); // object
// value = [];
// console.log(typeof value); // object
// value = null;
// console.log(typeof value); // object

// let value = 2 / 3;
// console.log(value); // 0.6666666666666666 (promote to floating point)
// value = 0.1 + 0.2;
// console.log(value); // 0.30000000000000004 (floating point errors)
// value = 2 / 0;
// console.log(value); // Infinity

// value = 2 + "5"; // string concatenation
// console.log(value); // 25
// console.log(typeof value); // string

// value = 2 * "5"; // math operation
// console.log(value); // 10
// console.log(typeof value); // number

// value = "15" - "5"; // math operation
// console.log(value); // 10
// console.log(typeof value); // number

// value = 2 / "Hodgepodge"; // math operation
// console.log(value); // NaN
// console.log(typeof value); // number

// console.log(value == NaN); // false
// console.log(isNaN(value)); // true

// console.log("5" == 5); // true
// console.log(5.0 == 5); // true
// console.log(0 == false); // true
// console.log(1 == true); // true
// console.log(null == undefined); // true

// console.log("5" == true); // false
// console.log(5 == "artichoke"); // false

// console.log("5" === 5); // false
// console.log(5.0 === 5); // true (both are numbers and 5)
// console.log(0 === false); // false
// console.log(1 === true); // false
// console.log(null === undefined); // false

// if (true) {
//   console.log("true literal is true");
// }

// if (false) {
//   console.log("false literal is true");
// }

// if ("Hodgepodge") {
//   console.log("string literal is true");
// }

// if (null) {
//   console.log("null literal is true");
// }

// if (undefined) {
//   console.log("undefined literal is true");
// }

// if ({}) {
//   console.log("object literal is true");
// }

// if ([]) {
//   console.log("array literal is true");
// }

// String literals
// let name = "Frank Ocean"; // Literals are delimited with either double quotes
// name = "Frank Ocean"; // or single quotes.

// let helloWorld = "你好，世界！"; // unicode

// // Choose the delimiter that makes it easy to express the literal.
// let message = "She doesn't like y'all."; // If it contains a ", use ''.
// message = 'He keeps doing those stupid "air quotes".'; // If it contains a ', use ""

// // Delimiters and special characters can be escaped.
// let message = "She doesn't like y'all.";
// message = 'He keeps doing those stupid "air quotes".';
// message = "This message\nspans\nmultiple\nlines and contains\ttabs.";

// // get the number of UTF-16 code units (characters, roughly) with a string's length property
// let codeUnitCount = name.length; // 14
// codeUnitCount = "你好，世界！".length; // 6

// let html = `<html lang="en">
// <head>
// <title>Document</title>
// <body>
//     <header>
//         <h1 class="main-header">Document Header</h1>
//     </header>
//     <main id="content">
//     </main>
// </body>
// </html>`;

// let name = "Nomi";
// let petCount = 3;
// let petType = "dogs";
// let verticalJump = 37.68;

// let message = `${name} has ${petCount} ${petType} and can jump ${verticalJump} inches vertically.`;

// console.log(message); // Nomi has 3 dogs and can jump 37.68 inches vertically.

// let a = 2.33;
// let b = -1.111;

// console.log(`${a} + ${b} = ${a + b}`); // 2.33 + -1.111 = 1.219

// i is not visible here.
// Referencing it causes an error.
// function loop() {
//   // i is visible here. Its value is undefined.
//   console.log(i);

//   for (var i = 0; i < 3; i++) {
//     // i is visible here.
//     console.log(i);
//   }

//   // i is visible here. Its value is 3.
//   console.log(i);
// }

// // i is not visible here (err).

// loop();

// i is not visible here (err).
// function loop() {
//   // i is not visible here (err).

//   for (let i = 0; i < 3; i++) {
//     // i is only visible in this block.
//     console.log(i);
//   }

//   // i is not visible here (err).
// }

// // i is not visible here (err).

// const value = "sesame oil";
// console.log(value); // sesame oil

// // ERROR:
// // TypeError: Assignment to constant variable.
// value = "grapeseed oil";
// console.log(value);

// const animalCount = 2;
// const canFly = true;

// if (animalCount > 1 && canFly) {
//   // true
//   console.log("a flock"); // executes
// }

// if (!canFly) {
//   // false
//   console.log("walker"); // doesn't execute
//   console.log("swimmer");
//   console.log("crawler");
// }

// const animalCount = 1;
// const canFly = false;

// if (animalCount > 1 && canFly) {
//   // false
//   // doesn't execute
//   console.log("a flock");
// } else {
//   // executes
//   console.log("could be a single bird");
//   console.log("a herd?");
//   console.log("either they can't fly");
//   console.log("or there's one or less animals");
// }

// if (!canFly) {
//   // true
//   // executes
//   console.log("walker");
//   console.log("swimmer");
//   console.log("crawler");
// } else {
//   // doesn't execute
//   console.log("plane, bird, dragonfly?");
// }

// const packageWeight = 0.55;

// if (packageWeight > 100.0) {
//   // check first condition
//   console.log("too big for standard shipping");
// } else if (packageWeight < 1.0) {
//   // check a second condition
//   console.log("too small. send a letter.");
// } else {
//   // the `else` clause executes if all other conditions are false.
//   console.log("can ship");
// }

// const color = "orange";

// if (color === "red") {
//   console.log("red's compliment is green");
// } else if (color === "blue") {
//   console.log("blue's compliment is orange");
// } else if (color === "yellow") {
//   console.log("yellow's compliment is purple");
// } else if (color === "green") {
//   console.log("green's compliment is red");
// } else if (color === "orange") {
//   console.log("orange's compliment is blue");
// } else if (color === "purple") {
//   console.log("purple's compliment is yellow");
// } else {
//   console.log("I don't know that color");
// }

// const place = 2;
// let ribbonColor;

// // 1. switch keyword, then an expression (often a variable) in parentheses, followed by a block
// switch (place) {
//   case 1: // 2. case keyword, then a literal value, then colon.
//     // if the switch's expression resolves to the case's value,
//     // all code nested inside the case executes.
//     ribbonColor = "blue";
//     console.log("first place!");
//     break; // 3. break keyword, immediately exits the switch's block
//   case 2:
//     ribbonColor = "red";
//     console.log("second place!");
//     break;
//   case 3:
//     ribbonColor = "white";
//     console.log("third place!");
//     break;
//   default: // 4. default keyword, executes when no other case matched
//     ribbonColor = "unknown";
// }

// console.log(ribbonColor);

// const message = "Visit Mars.";
// let index = 0;

// while (index < message.length) {
//   console.log(message.charAt(index));
//   index = index + 1;
// }

// let r = 0;
// do {
//   r = Math.random();
//   console.log(r);
// } while (r > 0.1); // ~10% chance to exit

/*
initialize: one-time set-up before looping begins 
condition: a boolean expression, looping continues while it evaluates to true 
after-each-loop: operations that occur after each loop

for (<initialize> ; <condition>; <after-each-loop>) {

}
*/

// const message = "Looping...";

// // Standard format
// for (let index = 0; index < message.length; index++) {
//   console.log(message.charAt(index));
// }

// // This loop is formatted to demonstrate the clauses.
// // The format isn't standard and may be confusing to a Java developer.
// for (
//   let index = 0; // initialize
//   index < message.length; // condition
//   index++ // after each loop
// ) {
//   console.log(message.charAt(index));
// }

// for (let i = 0; i < 5; i++) {
//   console.log(`Number: ${i}`);
//   if (i < 3) {
//     // jump to the next loop
//     continue;
//   }
//   console.log("Are we there yet?");
// }
// console.log("We're there!");

// let word = "I'm melting...";
// while (word.length > 0) {
//   if (word.length <= 3) {
//     // completely exits the loop. it's over.
//     break;
//   }
//   console.log(word);
//   word = word.substring(0, word.length - 1);
// }

/*
function           repeatStr   (value  , times  ) {
[function keyword] identifier {

    [body]

    return           result;
    [return keyword] [value]
}
*/

// function repeatStr(value, times) {
//   let result = "";
//   for (let i = 0; i < times; i++) {
//     result += value;
//   }
//   return result;
// }

// // no inputs
// function getRandomColor() {
//   switch (Math.floor(Math.random() * 4)) {
//     case 0:
//       return "red";
//     case 1:
//       return "blue";
//     case 2:
//       return "yellow";
//     default:
//       return "green";
//   }
// }

// // no output
// function repeatLog(message, times) {
//   for (let i = 0; i < times; i++) {
//     console.log(message);
//   }
// }

// const str = repeatStr("xo", 4); // str === "xoxoxoxo"
// const color = getRandomColor(); // color is one of "red", "blue", "yellow", or "green"
// repeatLog(str, 3); // prints "xoxoxoxo" to the JavaScript console 3 times.

// a bare-minimum function expression is:
// function           ()            {}
// [function keyword] [parentheses] [code block]

// console.log(typeof function () {}); // "function"

// // function expression can include parameters
// const repeatPrint = function (message, n) {
//   for (let i = 0; i < n; i++) {
//     console.log(message);
//   }
// };

// function executeTwice(func, message) {
//   func(message, 2);
// }

// // execute the function just like a declared function
// repeatPrint("Yellow", 2);

// const repeatMessage = repeatPrint;
// repeatMessage("Blue", 3);

// executeTwice(repeatPrint, "Red");
// executeTwice(repeatMessage, "Green");

// function declaration
// function getMathFunction(operator) {
//   switch (operator) {
//     case "+":
//       // function expression
//       return function (a, b) {
//         return a + b;
//       };
//     case "-":
//       // function expression
//       return function (a, b) {
//         return a - b;
//       };
//     case "*":
//       // function expression
//       return function (a, b) {
//         return a * b;
//       };
//     case "/":
//       // function expression
//       return function (a, b) {
//         return a / b;
//       };
//     default:
//       // function expression
//       return function () {};
//   }
// }

// const plus = getMathFunction("+");
// const multiply = getMathFunction("*");
// const unknown = getMathFunction("arrrgh");

// console.log(plus(2, 5)); // 7
// console.log(multiply(10.1, -5)); // -50.5
// console.log(unknown(1, 1)); // undefined

// function go(a, b, c) {
//   let message = "a: " + a + ", b: " + b + ", c: " + c;
//   console.log(message);
// }

// go(); // a: undefined, b: undefined, c: undefined
// go("maple"); // a: maple, b: undefined, c: undefined
// go("maple", -314); // a: maple, b: -314, c: undefined
// go("maple", -314, false); // a: maple, b: -314, c: false
// go("maple", -314, false, "killer squid"); // a: maple, b: -314, c: false
// go(1, 2, 3, 4, 5, 6, 7); // a: 1, b: 2, c: 3

// function goWithArguments() {
//   let args = Array.prototype.slice.call(arguments);
//   console.log(arguments.length + ": " + args.join());
// }

// goWithArguments(); // 0:
// goWithArguments("maple"); // 1: maple
// goWithArguments("maple", -314); // 2: maple,-314
// goWithArguments("maple", -314, false); // 3: maple,-314,false
// goWithArguments("maple", -314, false, "killer squid"); // 4: maple,-314,false,killer squid
// goWithArguments(1, 2, 3, 4, 5, 6, 7); // 7: 1,2,3,4,5,6,7

/*
Arrow function syntax is:
(name  )  =>     `Hello, ${name}!`     ;
([parm]) [arrow] [expression to return];
*/

// const greet = (name) => `Hello, ${name}!`;
// console.log(greet("Ayishat")); // "Hello, Ayishat!"

/*
Arrow functions can include multiple statements if a code block is included. 
In that case, the `return` keyword is required.
(a      , b      , c      ) =>      {
([parm1], [parm2], [parm3]) [arrow] [code block];
    return           "value";
    [return keyword] [value];
}          ;
[end block];
*/

// const minOfThree = (a, b, c) => {
//   let min = Math.min(a, b);
//   min = Math.min(min, c);
//   return min;
// };

// console.log(minOfThree(1, 2, 3)); // 1
// console.log(minOfThree(1, -2, 3)); // -2
// console.log(minOfThree(11, 222, 3)); // 3

// function getMathFunction(operator) {
//   switch (operator) {
//     case "+":
//       return (a, b) => a + b; // arrow func
//     case "-":
//       return (a, b) => a - b; // arrow func
//     case "*":
//       return (a, b) => a * b; // arrow func
//     case "/":
//       return (a, b) => a / b; // arrow func
//     default:
//       return () => {}; // arrow func
//   }
// }

// const plus = getMathFunction("+");
// const multiply = getMathFunction("*");
// const unknown = getMathFunction("arrrgh");

// console.log(plus(2, 5)); // 7
// console.log(multiply(10.1, -5)); // -50.5
// console.log(unknown(1, 1)); // undefined

// function f1(...args) {
//   console.log(args);
// }

// f1(); // [] (still an array, empty)
// f1(1); // [ 1 ]
// f1(1, 2, 3); // [ 1, 2, 3 ]

// function f2(a, b, ...c) {
//   console.log(a, b, c);
// }

// f2(); // undefined undefined []
// f2(1, 2); // 1 2 []
// f2(1, 2, 3, 4, 5); // 1 2 [ 3, 4, 5 ]

// function f3(a = 19, b = "chime", c) {
//   console.log(a, b, c);
// }

// f3(); // 19 chime undefined
// f3(27); // 27 chime undefined
// f3(27, "surf"); // 27 surf undefined
// f3(27, "surf", false); // 27 surf false

// function sayHello(name) {
//   return `Hello, ${name}!`;
// }

// // a default can use any expression in scope,
// // including function calls
// function f4(a, b = sayHello("Nunes")) {
//   console.log(a, b);
// }

// f4(); // undefined Hello, Nunes!
// f4(true); // true Hello, Nunes!
// f4(true, "Dr. Itch"); // true Dr. Itch

// const one = 1;
// // `one` is defined in global scope
// // global scope cannot see `two`, `three`, or `four`
// // global scope can see the outer function definition

// function outer() {
//   const two = 2;
//   // `two` is defined in outer's scope
//   // outer can see `one` and `two`
//   // but not `three` or `four`
//   // outer scope can see the mid function

//   function mid() {
//     const three = 3;
//     // `three` is defined in mid's scope
//     // mid can see see `one`, `two`, and `three`
//     // but not `four`
//     // mid can see the inner and outer functions

//     function inner() {
//       const four = 4;
//       // `four` is defined in inner's scope
//       // inner can see `one`, `two`, `three`, and `four`
//       // inner can see outer and mid function
//       console.log(one, two, three, four);
//     }
//   }
// }

// function outer() {
//   const outerState = "lilac";
//   return function () {
//     // this anonymous function closes over `outerState`
//     // even after outer's state is gone,
//     // `outerState` will still be available via this function
//     return "tulip " + outerState;
//   };
// }

// const flowerFunc = outer();
// // outer's state is now gone because function execution is complete.
// // `outerState` is not visible in this scope
// // and yet, "lilac" is printed to the console

// console.log(flowerFunc()); // tulip lilac

// let a1 = []; // Array literal - Good
// let a2 = new Array(); // ✗ Array constructor - not idiomatic

// initialize with any data type
// const colors = ["red", "blue", "yellow"];
// const evens = [2, 4, 6, 8];
// const booleans = [true, false];

// // types can be mixed
// const mixedContent = ["red", 2, false];

// const makeEven = () => Math.floor(Math.random() * 100) * 2;

// // can initialize dynamically
// const dynamicContext = [makeEven(), makeEven(), makeEven()];

// const mixedContent = ["red", 2, false];

// // access an element by index
// const color = mixedContent[0];
// console.log(color); // red

// // an intermediate variable isn't required
// console.log(mixedContent[0]); // red

// const likesCookies = mixedContent[2];
// console.log(likesCookies); // false

// // arrays are flexible, an out-of-bounds index is
// // not an error, the value is `undefined`
// const doesNotExist = mixedContent[22];
// console.log(doesNotExist); // undefined

// // store values
// // element types can change
// mixedContent[0] = "blue";
// mixedContent[2] = "green";
// console.log(mixedContent); // [ 'blue', 2, 'green' ]

// const colors = ["red", "blue", "yellow"];
// const evens = [2, 4, 6, 8];
// const booleans = [true, false];

// console.log(colors.length); // 3
// console.log(evens.length); // 4
// console.log(booleans.length); // 2

// const colors = ["red", "blue", "yellow"];

// colors[100] = "orange";
// console.log(colors.length); // 101
// console.log(colors[100]); // orange
// console.log(colors); // [ 'red', 'blue', 'yellow', <97 empty items>, 'orange' ]

// colors.length = 2;
// console.log(colors[2]); // undefined
// console.log(colors); // [ 'red', 'blue' ]

// colors.length = 25;
// console.log(colors); // [ 'red', 'blue', <23 empty items> ]

// const colors = ["red", "blue", "yellow"];

// colors.push("green");
// // [ 'red', 'blue', 'yellow', 'green' ]

// const length = colors.push("orange");
// // [ 'red', 'blue', 'yellow', 'green', 'orange' ]

// console.log(length); // 5

// colors.push("purple", "indigo", "violet");
// /*
// [
//     'red',    'blue',
//     'yellow', 'green',
//     'orange', 'purple',
//     'indigo', 'violet'
// ]
// */

// const colors = ["red", "blue", "yellow"];

// let color = colors.pop();
// // color  === "yellow"
// // colors === [ 'red', 'blue' ]

// color = colors.pop();
// // color  === "blue"
// // colors === [ 'red' ]

// colors.pop(); // remove "red"

// color = colors.pop();
// // color  === undefined
// // colors === []

// const colors = ["red", "blue", "yellow"];

// // The callback accepts an element from the array,
// // the element's index (optional)
// // and the original array (optional)
// function callback(elem, index, srcArray) {
//   console.log(elem, index, srcArray);
// }

// colors.forEach(callback);

// let html = "";
// // arrow functions are convenient for inline callbacks
// // can modify scope outside of the callback
// colors.forEach((elem) => (html += `<li>${elem}</li>\n`));
// console.log(html);

// const colors = ["red", "blue", "yellow"];

// for (const color of colors) {
//   console.log(`${color}`);
// }

// const colors = ["red", "blue", "yellow"];

// // the predicate accepts a value, an array element,
// // the element's index (optional)
// // and the source array (optional)
// function hasLengthFour(elem, index, srcArray) {
//   console.log(elem, index, srcArray);
//   return elem.length == 4;
// }

// // find ----------------------

// // returns the first element with a length of 4.
// let color = colors.find(hasLengthFour);
// console.log(color); // blue

// // returns the first element that starts with "y"
// color = colors.find((elem) => elem.startsWith("y"));
// console.log(color); // yellow

// // returns the first element that ends with "ing"
// color = colors.find((elem) => elem.endsWith("ing"));
// console.log(color); // undefined

// // findIndex --------------------

// // returns the first index from an element with a length of 4.
// let index = colors.findIndex(hasLengthFour);
// console.log(index); // 1

// // returns the first index from an element that starts with "y"
// index = colors.findIndex((elem) => elem.startsWith("y"));
// console.log(index); // 2

// // returns the first index from an element that ends with "ing"
// index = colors.findIndex((elem) => elem.endsWith("ing"));
// console.log(index); // -1

// const beelike = [
//   "Hoverfly",
//   "Banded white-tailed bumblebee",
//   "Bee fly",
//   "Orange-tailed mining bee",
// ];

// const flies = beelike.filter((b) => b.includes("fly"));
// console.log(flies);
// // [ 'Hoverfly', 'Bee fly' ]

// const longNames = beelike.filter((b) => b.length > 10);
// console.log(longNames);
// // [ 'Banded white-tailed bumblebee', 'Orange-tailed mining bee' ]

// const numbers = [1, 2, 3, 4, 5];

// let result = numbers.some((n) => n % 3 == 0);
// console.log(result); // divisible by 3? true

// result = numbers.some((n) => n > 100);
// console.log(result); // greater than 100? false

// const numbers = [1, 2, 3, 4, 5];

// let result = numbers.every((n) => n % 3 == 0);
// console.log(result); // divisible by 3? false

// result = numbers.every((n) => n < 100);
// console.log(result); // less than 100? true

// result = ["red", "blue", "yellow"].every((c) => !c.includes(" "));

// console.log(result); // no whitespace? true

// const numbers = [1, 2, 3, 4, 5];
// const colors = ["red", "blue", "yellow"];

// let result = numbers.includes(4);
// console.log(result); // true

// result = numbers.includes(14);
// console.log(result); // false

// result = colors.includes("blue");
// console.log(result); // true

// // string comparisons are case sensitive
// result = colors.includes("Blue");
// console.log(result); // false

// const numbers = [1, 2, 3, 4, 5];
// const colors = ["red", "blue", "yellow"];

// // mapping function accepts a string parameter
// // and returns a number
// const lengths = colors.map((c) => c.length);
// console.log(lengths); // [ 3, 4, 6 ]

// // mapping function accepts a number parameter
// // and returns a new number
// const doubled = numbers.map((n) => n * 2);
// console.log(doubled); // [ 2, 4, 6, 8, 10 ]

// // mapping function accepts a string parameter
// // and returns a new string
// const upperCaseColors = colors.map((c) => c.toUpperCase());
// console.log(upperCaseColors); // [ 'RED', 'BLUE', 'YELLOW' ]

// const numbers = [1, 2, 3, 4, 5];
// const colors = ["red", "blue", "yellow"];

// // mapping function accepts a string parameter
// // and returns a number
// const lengths = colors.map((c) => c.length);
// console.log(lengths); // [ 3, 4, 6 ]

// // mapping function accepts a number parameter
// // and returns a new number
// const doubled = numbers.map((n) => n * 2);
// console.log(doubled); // [ 2, 4, 6, 8, 10 ]

// // mapping function accepts a string parameter
// // and returns a new string
// const upperCaseColors = colors.map((c) => c.toUpperCase());
// console.log(upperCaseColors); // [ 'RED', 'BLUE', 'YELLOW' ]

// accumulator: the aggregated result so far
// currentElement: `reduce` iterates over each element -
//    this is the current element.
// function reduce(accumulator, currentElement) {
//   return; // return the next accumulated value
// }

// const numbers = [1, 2, 3, 4, 5];
// const colors = ["red", "blue", "yellow", "green"];

// function min(accumulator, currentElement) {
//   return Math.min(accumulator, currentElement);
// }

// // any reducer function works as long as it accepts
// // the expected parameters.

// // use a declared function
// const minValue = numbers.reduce(min);
// console.log(minValue); // 1

// // use an arrow function
// const maxValue = numbers.reduce((a, c) => Math.max(a, c));
// console.log(maxValue); // 5

// const sum = numbers.reduce((a, c) => a + c);
// console.log(sum); // 15

// // use a function expression
// const firstLetterReducer = function (accumulator, currentElement) {
//   let result = "";
//   if (accumulator.length > 0) {
//     result = ",";
//   }
//   return `${accumulator}${result}${currentElement.charAt(0)}`;
// };

// // the second argument, "", is an initial value
// // if no initial value is specified, the first element is used
// // and looping starts with the second element.
// const firstLetters = colors.reduce(firstLetterReducer, "");
// console.log(firstLetters); // r,b,y,g

// const numbers = [3, 2, 1, 5, 4];
// const colors = ["red", "blue", "yellow", "green"];

// const sorted = numbers.sort();
// console.log(sorted); // [ 1, 2, 3, 4, 5 ]
// console.log(numbers); // [ 1, 2, 3, 4, 5 ]
// console.log(sorted === numbers); // the same array

// colors.sort();
// console.log(colors); // [ 'blue', 'green', 'red', 'yellow' ]

// const numbers = [3, 2, 1, 5, 4];
// const colors = ["red", "blue", "yellow", "green"];

// function sortDescending(a, b) {
//   // ascending would be a - b;
//   return b - a;
// }

// let sorted = numbers.sort(sortDescending);
// console.log(sorted);

// // a random sort isn't predictable and it's not sorting
// // in the proper sense, but it's an interesting trick
// // to "shuffle" array elements randomly.
// sorted = numbers.sort((a, b) => Math.random() - 0.5);
// console.log(sorted);

// // sort strings descending
// sorted = colors.sort((a, b) => b.localeCompare(a));
// console.log(sorted);

// const roygbivCompare = function (a, b) {
//   const roygbiv = "roygbiv";
//   return roygbiv.indexOf(a.charAt(0)) - roygbiv.indexOf(b.charAt(0));
// };

// // sort in Roy G. Biv order
// // (red, orange, yellow, green, blue, indigo, violet)
// sorted = colors.sort(roygbivCompare);
// console.log(sorted);

// const colors = ["red", "orange", "yellow", "green", "blue", "indigo", "violet"];

// // start at index 1 (zero-based).
// // index 5 is not included
// let result = colors.slice(1, 5);
// console.log(result);
// // [ 'orange', 'yellow', 'green', 'blue' ]

// // start at index 2 and run to the end of the array.
// result = colors.slice(2);
// console.log(result);
// // [ 'yellow', 'green', 'blue', 'indigo', 'violet' ]

// // the start is offset from the end of the array.
// // this grabs the last 2 elements
// result = colors.slice(-2);
// console.log(result);
// // [ 'indigo', 'violet' ]

// // leave off elements at the ends of the array.
// result = colors.slice(1, -1);
// console.log(result);
// // [ 'orange', 'yellow', 'green', 'blue', 'indigo' ]

// // is start is bigger than end, an empty array is returned.
// result = colors.slice(5, 2);
// console.log(result);
// // []

// const colors = ["red", "orange", "indigo", "violet"];

// // start at 2, don't delete, add three new colors
// let result = colors.splice(2, 0, "yellow", "green", "green");
// console.log(result); // []
// console.log(colors);
// // ['red', 'orange', 'yellow', 'green', 'green', 'indigo', 'violet']

// // start at 4, delete one (green), add blue
// result = colors.splice(4, 1, "blue");
// console.log(result); // ['green']
// console.log(colors);
// // ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet']

// // start at 1, delete two, add nothing
// result = colors.splice(1, 2);
// console.log(result); // [ 'orange', 'yellow' ]
// console.log(colors);
// // [ 'red', 'green', 'blue', 'indigo', 'violet' ]

// const warmColors = ["red", "orange", "yellow"];
// const coolColors = ["green", "blue", "indigo", "violet"];
// const otherColors = ["pink", "maroon"];

// // spread into individual elements
// const allColors = [...warmColors, ...coolColors, ...otherColors];
// console.log(allColors);

// const a1 = [2, 3];
// const a2 = [6, 7];

// // spread syntax can be combined with values
// const numbers = [1, ...a1, 4, 5, ...a2, 8, 9];
// console.log(numbers);

// // copy an array with spread syntax
// const copy = [...numbers];

// function makeName(honorary, first, last) {
//   return `${honorary} ${first} ${last}`;
// }

// const values = ["Dr.", "Mean", "Itch"];

// // spread values into argument that match parameters
// const n = makeName(...values);
// console.log(n); // Dr. Mean Itch

// const colors = ["red", "blue", "yellow"];

// // array destructuring use square brackets to show which
// // index/element should be assigned to which variable.
// const [a, b, c] = colors;
// console.log(a); // red (string, no longer related to the array)
// console.log(b); // blue
// console.log(c); // yellow

// let blue;
// // elements are ignored by leaving empty spaces between commas.
// [, blue] = colors;

// console.log(blue); // blue

// const numbers = [2, 4, 6, 8, 10];

// const [, element, ...lastThree] = numbers;

// console.log(element); // 4 (number)
// console.log(lastThree); // [ 6, 8, 10 ] (array of numbers)

// function makeArray() {
//   return ["tulip", "peony", "lilac", "dandelion"];
// }

// let a, b, c;
// [b, c, a] = makeArray();
// console.log(a); // lilac
// console.log(b); // tulip
// console.log(c); // peony

// // Create object with object literal notation.
// let planet = {};
// // Dynamically add 3 properties. Properties can have any type, including `function`.
// planet.name = "Jupiter";
// planet.moons = ["Io", "Europa", "Ganymede"];
// planet.getDescription = function () {
//   return "Planet: " + this.name + ", Has " + this.moons.length + " moons.";
// };

// console.log(planet.name); // Jupiter
// console.log(planet.moons[2]); // Ganymede
// console.log(planet.moons.length); // 3
// console.log(planet.getDescription()); // Planet: Jupiter, Has 3 moons.
// console.log(planet.diameter); // undefined

let planet = {};
planet["name"] = "Jupiter";
planet["moons"] = ["Io", "Europa", "Ganymede"];
planet["getDescription"] = function () {
  return "Planet: " + this.name + ", Has " + this.moons.length + " moons.";
};
planet["is a planet with rings"] = true;

console.log(planet["name"]); // Jupiter
console.log(planet["moons"][2]); // Ganymede
console.log(planet["moons"].length); // 3
console.log(planet["getDescription"]()); // Planet: Jupiter, Has 3 moons.
console.log(planet["is a planet with rings"]); // true
console.log(planet["diameter"]); // undefined
