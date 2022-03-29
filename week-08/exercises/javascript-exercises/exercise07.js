const assert = require("assert");

// FIRST VOWEL
// Complete the function `getFirstVowel`.
// It should return the first vowel in a string.
// If the string doesn't contain vowels, `value` is null,
// or `value` is undefined, return an empty string.

function getFirstVowel(value) {
  for (let i = 0; i < value.length; i++) {
    if (
      value[i] === "a" ||
      value[i] === "e" ||
      value[i] === "i" ||
      value[i] === "o" ||
      value[i] === "u"
    ) {
      return value[i];
    } else if (value == "") {
      return "";
    }
  }
  return "";
}

// Node's assert library will test your function.
// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.strictEqual(getFirstVowel("magnificent"), "a");
assert.strictEqual(getFirstVowel("winsome"), "i");
assert.strictEqual(getFirstVowel("xxx"), "");
assert.strictEqual(getFirstVowel(), "");
assert.strictEqual(getFirstVowel("mAgnificent"), "A");

console.log("success!");
