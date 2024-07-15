
QUnit.test("testRegistration",async function(assert)
{
    /*
        Register a new user.
        May need additional two factor steps for creating
        new accounts since anyone can do it right now
    */
    const userToCreate={
        name:"unitNonAdminUser",
        password:"pass12345",
        secretInformation:"This is only accessible to this user"
    }

    const newUserCreated=await myFetch(`POST`,`/project1-back/users/register`,true,null,userToCreate)
    assert.true(newUserCreated.userId>0,"new user id was something")
    assert.equal(userToCreate.name,newUserCreated.name, "name matches")
    assert.equal(newUserCreated.password,"",            "responded password is gone. good.")
    assert.equal(newUserCreated.secretInformation,"",   "secretInformation was not revealed")

    /*
        Login as that new user
    */
//    const newUserCreated=await myFetch(`/users`,`POST`,true,
//            {username:`qunitNonAdminUser`,password:`pass12345`},)
})