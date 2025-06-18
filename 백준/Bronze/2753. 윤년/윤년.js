const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString();
const year = Number(input);

if(year % 4 === 0) {
    if(year % 100 !== 0) console.log(1);
    else if(year % 100 === 0 && year % 400 == 0) console.log(1);
    else console.log(0);
} else {
    console.log(0);
}
