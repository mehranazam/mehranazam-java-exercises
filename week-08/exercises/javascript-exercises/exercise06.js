// INTERLEAVE
const first = "abc";
const second = "123";
let output = "";

// 1. Write a loop to interleave two strings to form a new string.
// To interleave, during each loop take one character from the first string and add it to the result
// and take one character from the second string and add it to the result.
// If there are no more characters available, don't add characters.
// 2. Print the result.

// Examples
// "abc", "123" -> "a1b2c3"
// "cat", "dog" -> "cdaotg"
// "wonder", "o" -> "woonder"
// "B", "igstar" -> "Bigstar"
// "", "huh?" -> "huh?"
// "wha?", "" -> "wha?"

if (first == "" && second == "") {
  console.log("");
} else if (second == "") {
  console.log(first);
} else if (first == "") {
  console.log(second);
} else {
  let max = 0;
  if (first.length > second.length) {
    max = first.length;
  } else if (first.length < second.length) {
    max = second.length;
  }
  for (let i = 0; i < max.length; i++) {
    output = output + (first[i] + second[i]);
  }
  console.log(output);
}
