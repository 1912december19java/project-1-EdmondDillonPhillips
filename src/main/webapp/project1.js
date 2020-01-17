'user strict'

let employeeForm = document.getElementById('employeeForm');
let managerForm = document.getElementById('managerForm');
let employeeNumber = document.getElementById('employeeNumber');
let managerNumber = document.getElementById('managerNumber');
let receivedContent = document.getElementById('content');

let employeeUri = "http://localhost:8080/Project1/employee";
let managerUri;




employeeForm.addEventListener('submit', (event)=>{
    let empVal = employeeNumber.value(); 
    console.log(empVal);
	event.preventDefault();
    getData();
})

async function getData(){

    await fetch(employeeUri)
    .then((response) => {
        return response.json();
      })
    .then((myJson)=>{
        console.log(myJson)
    })


     
}

// fetch(employeeUri)
// .then((res)=>{
//     //This take the text of the body, parses it as JSON,
//     //and gives us an object
//     return res.json();
// })
// .then((employee)=>{
//     //we can do something with the employee object
//     let keysHeader = document.createElement('h2');
//     keysHeader.innerText = 'Employee Info: '
//     receivedContent.appendChild(keysHeader);
//     for(let key in employee){
//         let newElement = document.createElement('p');
//         newElement.innerText = key;
//         receivedContent.appendChild(newElement);
//     }
// })
// .catch(console.error)


