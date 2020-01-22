'use strict'

let employeeLoginForm = document.getElementById("employeeLoginForm");
let employeeNumber = document.getElementById("employeeNumber")
let employeeLoginFormUrl = "http://localhost:8080/Project1/employeelogin";

employeeLoginForm.addEventListener('submit', employeeLogin);

let employeeData;

async function employeeLogin(e){
    e.preventDefault();
    let empVal = {};

    empVal.employeeNumber = employeeNumber.value;
    console.log(JSON.stringify(empVal));
    let response = await fetch(employeeLoginFormUrl,
        { method: 'POST', body: JSON.stringify(empVal)})
        .then(response => response.text())
        .then((data)=>{
            employeeData = JSON.parse(data)
        })
        console.log(employeeData.employeeNumber)
        // employeeData = JSON.parse(response);
    // employeeData = JSON.parse(response);
    // console.log(employeeData.employeeNumber);
    // console.log(employeeData.employeeFirstName);
    // console.log(employeeData.employeeLastName);
    // console.log(employeeData.employeeEmail);

//========================================================================
    // await fetch(employeeLoginFormUrl,
    // { method: 'POST', body: JSON.stringify(empVal)})
    // .then(response =>   response.json())
    // .then((data)=>{
    //     console.log(data)
    // })
//=======================================================================
    // .catch((error) => {
    //     console.error('There has been a problem with your fetch operation:', error);
    //   });

    // let response = await fetch(employeeLoginFormUrl,
    //     { method: 'POST', body: JSON.stringify(empVal)});

    // console.log(response.body.text());
    

    // console.log('after response');
    // employeeData = JSON.parse(response.json());

};

console.log(employeeData);