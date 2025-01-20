//1. Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất

function getStringHasMaxLength(strings) {
    const maxLength = Math.max(...strings.map(str => str.length));
    return strings.filter(str => str.length === maxLength);
}
// Ex:
console.log(getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd'])); // ['aba', 'vcd']
//2.1 Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true
users = [
  {
    name: "Bùi Công Sơn",
    age: 30,
    isStatus: true,
  },
  {
    name: "Nguyễn Thu Hằng",
    age: 27,
    isStatus: false,
  },
  {
    name: "Phạm Văn Dũng",
    age: 20,
    isStatus: false,
  },
];

function filterUsers(users) {
  return users.filter((user) => user.age > 25 && user.isStatus);
}
console.log(filterUsers(users));
//2.2 Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần
function sortUsersByAge(users) {
  return users.slice().sort((a, b) => a.age - b.age);
}
console.log(sortUsersByAge(users));
//3. Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần
function getCountElement(array) {
  return array.reduce((countObj, item) => {
    countObj[item] = (countObj[item] || 0) + 1; 
    return countObj;
  }, {});
}

console.log(getCountElement(["one", "two", "three", "one", "one", "three"]));
