

import uac from "../src/controllers/userAccountController.js"
import myFetch from "./myFetch.js"
//import QUnit from "./index.html"

QUnit.test("testRegistration",async function(assert)
{
    /*
        Make sure tables are cleared for this test
    */
    // const anyBody=await myFetch(`DELETE`,`/project1-back/development/all`,true,null,null)
    // assert.equal(anyBody.message,"Cleared all database tables", "Response as successful")

    /*
        Register a new user.
        May need additional two factor steps for creating
        new accounts since anyone can do it right now
    */
    const userToCreate={
        name:"qunitNonAdminUser",
        password:"pass12345",
        secretInformation:"This is only accessible to this user"
    }

    //const newUserCreated=await myFetch(`POST`,`/project1-back/users/register`,true,null,userToCreate)
    // assert.true(newUserCreated.userId>0,"new user id was something")
    // assert.equal(newUserCreated.name,userToCreate.name, "name matches")
    // assert.equal(newUserCreated.password,null,          "responded password is gone. good.")
    // assert.equal(newUserCreated.secretInformation,null, "secretInformation was not revealed")

    await uac.register(userToCreate.name,userToCreate.password,userToCreate.secretInformation)
    assert.true(uac.newUserCreated.userId>0,"new user id was something")
    assert.equal(uac.newUserCreated.name,userToCreate.name, "name matches")
    assert.equal(uac.newUserCreated.password,null,          "responded password is gone. good.")
    assert.equal(uac.newUserCreated.secretInformation,null, "secretInformation was not revealed")
    

    /*
        Login successfully as that new user
    */
    // const loggedInUser=await myFetch(`POST`,`/project1-back/users/login`,true,
    //        {username:`qunitNonAdminUser`,password:`pass12345`},null)
    await uac.login(`qunitNonAdminUser`,`pass12345`)
    assert.equal(uac.loggedInUser.name,`qunitNonAdminUser`, "name matches")
    assert.equal(uac.loggedInUser.password,null,            "responded password is gone. good.")
    assert.equal(uac.loggedInUser.secretInformation,null,   "secretInformation was not revealed")

    /*
        Access information only that user should have
    */
    // let body=await myFetch(`GET`,`/project1-back/users/my-private-info`,true,
    //     {tokenId:uac.loggedInUser.tokenId,tokenPassword:uac.loggedInUser.tokenPassword},null)
    await uac.myPrivateInfo()
    assert.equal(uac.loggedInUser.secretInformation,"This is only accessible to this user", "secret information matches")

    /*
            Successfully logout the logged in user
    */
    // let bodyLogout=await myFetch(`POST`,`/project1-back/users/logout`,true,
    //     {tokenId:uac.loggedInUser.tokenId,tokenPassword:uac.loggedInUser.tokenPassword},null)
    let logoutMessage=await uac.logout()
    assert.equal(logoutMessage,"You have been logged out","logout worked great")

    
    /*
        Check that the logged in user was set to null after logging out
    */
    let nothing=await uac.myPrivateInfo()
    assert.equal(nothing,"","Nothing happended when we get private info, we're already logged out.")



    /*
        Try to access the secret information without a tokenId or tokenPassword
        1. shows that others are denied access
        2. logged out user is also denied access
    */
    uac.loggedInUser={
        tokenId:"badGuyGuessingTokenId",
        tokenPassword:"badGuyGuessingTokenPassword",
    }

    try{
        await uac.myPrivateInfo()
        assert.true(false,"Error should have happened. Can not reach this")
    }catch(ex){
        //console.log(`ex.message=`,ex.message)
        assert.equal(ex.message,
            `response status 401 "No Valid session for account within database"`,
            `401 error was thrown`)
    }


    // let response=await myFetch(`GET`,`/project1-back/users/my-private-info`,false,
    //     {tokenId:"guessingTheTokenId",tokenPassword:"guessingTheTokenPassword"},null)
    // assert.equal(response.status,401,"Expected 401 response status returned")
    // let body2=await response.json()
    // assert.equal(body2.errorMessage,"No Valid session for account within database","No valid session for this user")
    // assert.equal(body2.secretInformation,null,"secretInformation was not revealed")
    
    
})