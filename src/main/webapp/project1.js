'user strict'

let employeeForm = document.getElementById('employeeForm');
let managerForm = document.getElementById('managerForm');
let employeeNumber = document.getElementById('employeeNumber');
let managerNumber = document.getElementById('managerNumber');
let receivedContent = document.getElementById('content');

let employeeUri = "http://localhost:8080/Project1/employee";
let managerUri;
let empVal;


// employeeForm.addEventListener('submit', (event)=>{
    
// 	event.preventDefault();
//     getEmployeeData();
// })



// function getEmployeeData() {

//    empVal = employeeNumber.value;
//    console.log(empVal);
//    let xhr = new XMLHttpRequest();
 
//    console.log(xhr.readyState);
   
//    xhr.addEventListener('readystatechange', (event)=>{
//      console.log(xhr.readyState);


 
//      if(xhr.readyState === xhr.DONE) {

//        //We've received some response since the readystate is DONE
//        let response = xhr.response;
//        console.log(response);
 
//        //condition for success/failure:
//        if(xhr.status >= 200 && xhr.status < 300) {
//          console.log(`Success with status ${xhr.status}`);

//        } else {
//          console.error(`Failure with status ${xhr.status}`);
//        }
//      }
//    });

//    xhr.open('POST', employeeUri);
 
//    //actually send
//    xhr.send(empVal);
 

//  }



//=========================








employeeForm.addEventListener('submit', (event)=>{

	event.preventDefault();
    employeeLogin();
})

async function employeeLogin(){

    let empVal = {};

    empVal.employeeNum = employeeNumber.value;
    console.log(JSON.stringify(empVal));
    let response = await fetch(employeeUri, { method: 'POST', body: JSON.stringify(empVal)});
    console.log(response);

    // await fetch(employeeUri)
    // .then((response) => {
    //     return response.json();
    //   })
    // .then((myJson)=>{
    //     console.log(myJson)
    // })


     
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


