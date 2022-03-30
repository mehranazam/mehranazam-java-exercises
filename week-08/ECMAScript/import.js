// import all exports and alias as 'compliments'
import * as compliments from "./index.js";

console.log(compliments);
// [Module] {
//     Dance: [Function: Dance],
//     getNeatoCompliment: [Function: getNeatoCompliment],
//     getSuperCompliment: [Function: getSuperCompliment],
//     greeting: 'Hey'
//   }

// import specific named exports - object destructuring
import { greeting, getNeatoCompliment } from "./compliments.js";

console.log(greeting); // Hey
console.log(getNeatoCompliment); // [Function: getNeatoCompliment]

// import specific names and give them an alias
import {
  greeting as message,
  getSuperCompliment as makeSuperCompliment,
} from "./compliments.js";

console.log(message); // Hey
console.log(makeSuperCompliment); // [Function: getSuperCompliment]
