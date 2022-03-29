const Arrays = (arr) => {
  let longestStringLength = 0;
  let modifiedStringArray = [];

  for (let i = 0; i < arr.length; i++) {
    if (longestStringLength < arr[i].length) {
      longestStringLength = arr[i].length;
    }
    // console.log(arr[i]);
  }

  for (let i = 0; i < arr.length; i++) {
    if (arr[i].length <= longestStringLength) {
      let difference = longestStringLength - arr[i].length;
      let spacedWord = " ".repeat(difference) + arr[i];
      modifiedStringArray.push(spacedWord);
    }
  }

  for (let i = 0; i < arr.length; i++) {
    console.log(modifiedStringArray[i]);
  }
};

let arr = ["dog", "cat", "hamster"];

let arr1 = ["yes", "no"];

Arrays(arr1);
