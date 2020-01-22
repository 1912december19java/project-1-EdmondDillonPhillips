'use strict'
//==========================================================================
//----------------- Login variables ------------------------------------
//=======================================================================
let loginFormContainer = document.getElementById("loginFormContainer");
//------------------ Employee Login ------------------------------------
let employeeLoginForm = document.getElementById("employeeLoginForm");
let employeeNumber = document.getElementById("employeeNumber")
let employeeLoginFormUrl = "http://localhost:8080/Project1/employeelogin";
//------------------ Manager Login --------------------------------------

//========================================================================
//------------------ Employee Info Variables ----------------------------
//==========================================================================
let employeeData;
let employeeInfo = document.getElementById("employeeInfo");
//========================================================================
//------------------ Manager Info Variables ----------------------------
//==========================================================================



//=========================================================================
//------------------ Event Listeners --------------------------------------
//=========================================================================

employeeLoginForm.addEventListener('submit', employeeLogin);


//=========================================================================
//---------------------- Functions ----------------------------------------
//=========================================================================
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

    createEmployeeInfo();
    loginFormContainer.remove();
};
//========================================================================

function createEmployeeInfo(){

    let empno = document.createElement("div");
    let empnotxt = document.createTextNode(employeeData.employeeNumber);
    empno.appendChild(empnotxt);
    let empfrstnm = document.createElement("div");
    let empfrstnmtxt = document.createTextNode(employeeData.employeeFirstName);
    empfrstnm.appendChild(empfrstnmtxt);
    let emplstnm = document.createElement("div");
    let emplstnmtxt = document.createTextNode(employeeData.employeeLastName);
    emplstnm.appendChild(emplstnmtxt);
    let empemail = document.createElement("div");
    let empemailtxt = document.createTextNode(employeeData.employeeEmail);
    empemail.appendChild(empemailtxt);


    employeeInfo.appendChild(empno);
    employeeInfo.appendChild(empfrstnm);
    employeeInfo.appendChild(emplstnm);
    employeeInfo.appendChild(empemail);

    createLogoutButton();


}
//=========================================================================

function createLogoutButton(){
    let logoutButton = document.createElement("a");
    let logoutButtonText = document.createTextNode("Logout");
    logoutButton.setAttribute("href", "http://localhost:8080/Project1/")
    logoutButton.appendChild(logoutButtonText);
    employeeInfo.appendChild(logoutButton);
    logoutButton.addEventListener('click', function(){
        employeeInfo.remove();
    })
}

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



