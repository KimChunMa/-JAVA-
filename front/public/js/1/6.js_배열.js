let array = ["자료1", "자료2", "자료3"];
const array2  = ["자료1", "자료2", "자료3"];

console.log(array[0], array[1], array[2] )
console.log(array[0],array[1],array[2] )
console.log(array)
console.log(array2.length)

document.write(array)
document.write('<h3>'+array+'<h3>') //HTML 마크업은 JS내에 문자열 처리


document.write('<ol>')
document.write('<li>'+array[0]+'</li>')
document.write('<li>'+array[1]+'</li>')
document.write('<li>'+array[2]+'</li>')
document.write('<p>'+array.length+'</p>')
document.write('<ol>')


array.push("자료4")
console.log(array[3])

array.splice(0,2); //인덱스 0~2까지 제거
console.log(array)

array.splice(0); //모든 배열 삭제
console.log(array)



