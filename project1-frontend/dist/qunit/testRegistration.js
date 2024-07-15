
QUnit.test("testRegistration",async function(assert)
{
    /*
        Make sure tables are cleared for this test
    */
    const anyBody=await myFetch(`DELETE`,`/project1-back/development/all`,true,null,null)
    assert.equal(anyBody.message,"Cleared all database tables", "Response as successful")

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

    const newUserCreated=await myFetch(`POST`,`/project1-back/users/register`,true,null,userToCreate)
    assert.true(newUserCreated.userId>0,"new user id was something")
    assert.equal(newUserCreated.name,userToCreate.name, "name matches")
    assert.equal(newUserCreated.password,null,          "responded password is gone. good.")
    assert.equal(newUserCreated.secretInformation,null, "secretInformation was not revealed")

    /*
        Login as that new user
    */
    const loggedInUser=await myFetch(`POST`,`/project1-back/users/login`,true,
           {username:`qunitNonAdminUser`,password:`pass12345`},null)
    assert.equal(loggedInUser.name,`qunitNonAdminUser`, "name matches")
    assert.equal(loggedInUser.password,null,            "responded password is gone. good.")
    assert.equal(loggedInUser.secretInformation,null,   "secretInformation was not revealed")

    /*
        Access information only that user should have
    */
    let body=await myFetch(`GET`,`/project1-back/users/my-private-info`,true,
        {tokenId:loggedInUser.tokenId,tokenPassword:loggedInUser.tokenPassword},null)
    assert.equal(body.secretInformation,"This is only accessible to this user", "secret information matches")

    /*
        Try to access the secret information without a tokenId or tokenPassword
        to show that others are denied access like we expect
    */

    let response=await myFetch(`GET`,`/project1-back/users/my-private-info`,false,
        {tokenId:"guessingTheTokenId",tokenPassword:"guessingTheTokenPassword"},null)
    assert.equal(response.status,401,"Expected 401 response status returned")
    let body2=await response.json()
    assert.equal(body2.errorMessage,"No Valid session for account within database","No valid session for this user")
    assert.equal(body2.secretInformation,null,"secretInformation was not revealed")
    
   /*
        Successfully logout the logged in user
   */
    let bodyLogout=await myFetch(`POST`,`/project1-back/users/logout`,true,
        {tokenId:loggedInUser.tokenId,tokenPassword:loggedInUser.tokenPassword},null)
    assert.equal(bodyLogout.message,"You have been logged out","logout worked great")
})