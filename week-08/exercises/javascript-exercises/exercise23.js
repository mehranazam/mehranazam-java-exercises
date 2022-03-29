// ITEM BETWEEN ARRAYS
// Create a function that accepts an array, any other value, and an array.
// Return a new array that includes all elements from the first array, the value, then
// all the elements from the last array parameter.
// Hint: spread syntax is useful here.

function Arr(arr1, b, arr2) {
  const a1 = [...arr1, b, ...arr2];
  return a1;
}

/* Examples
[1, 2], "a", [true]                   => [1, 2, "a", true]
[], 87, [9]                           => [87, 9]
[14, 15], 0, []                       => [14, 15, 0]
["red", "blue"], "orange", ["yellow"] => ["red", "blue", "orange", "yellow"]
["red"], ["orange"], ["yellow"]       => ["red", ["orange"], "yellow"]
*/

// Confirm your result by debugging or printing to the console.

let arr1 = [];
let b = 87;
let arr2 = [9];

console.log(Arr(arr1, b, arr2));
