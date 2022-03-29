const assert = require("assert");
// THREE FUNCTIONS

// 1. Create a function.
// Name: areInOrder
// Parameters: number, number, number
// Returns: boolean
// Description: return true if the three parameters are in ascending order.
// Otherwise, returns false.
// (See exercise08.)

const areInOrder = function (a, b, c) {
  const numbers = [a, b, c];
  const sorted = numbers.sort();
  if (a <= b && b <= c) {
    return true;
  }

  /*
  if (numbers === sorted) {
    return true;
  }
  */
  return false;
};

// 2. Create a function.
// Name: areContiguous
// Parameters: number, number, number
// Returns: boolean
// Description: return true if a parameter is one step away from the next parameter. That is, they're "next to" one
// another. A step can be either a step up or a step down.
// Otherwise, returns false.
// Examples
// 1, 2, 3 -> true
// 1, 1, 2 -> false (first param must be either one less or one more than the second)
// 1, 2, 1 -> true
// 1, 5, 7 -> false
// 0, 1, 2 -> true
// 7, 6, 5 -> true
// 7, 5, 6 -> false
// 1, 0, 1 -> true

function areContiguous(a, b, c) {
  if (Math.abs(a - b) === 1 && Math.abs(b - c) === 1) {
    return true;
  }
  return false;
}

// 3. Create a function.
// Name: isAscendingContiguous
// Parameters: number, number, number
// Returns: boolean
// Description: return true if the three parameters are in ascending order and are contiguous
// Otherwise, returns false.
// Hint: call areInOrder and areContiguous. Neither method can guarantee the result alone, but together they solve
// the problem.

function isAscendingContiguous(a, b, c) {
  const ordered = areInOrder(a, b, c);
  const contiguous = areContiguous(a, b, c);
  if (ordered && contiguous) {
    return true;
  }
  return false;
}

// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.strictEqual(isAscendingContiguous(3, 4, 5), true);
assert.strictEqual(isAscendingContiguous(-10, 4, 100), false);
assert.strictEqual(isAscendingContiguous(2, 1, 2), false);
assert.strictEqual(isAscendingContiguous(5, 4, 3), false); // not ascending

assert.strictEqual(areContiguous(1, 2, 3), true);
assert.strictEqual(areContiguous(1, 1, 2), false);
assert.strictEqual(areContiguous(1, 2, 1), true);
assert.strictEqual(areContiguous(1, 5, 7), false);
assert.strictEqual(areContiguous(0, 1, 2), true);
assert.strictEqual(areContiguous(7, 6, 5), true);
assert.strictEqual(areContiguous(7, 5, 6), false);
assert.strictEqual(areContiguous(1, 0, 1), true);

console.log("success!");
