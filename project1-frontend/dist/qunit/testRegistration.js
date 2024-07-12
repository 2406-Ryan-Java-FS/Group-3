
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

    const newUserCreated=await myFetch(`POST`,`/users`,true,null,userToCreate)
    assert.true(newUserCreated.userId>0,"new user id was something")
    assert.equals(userToCreate.name,newUserCreated.name,"name matches")
    assert.equals("",newUserCreated.name,"responded password is gone. good.")
    assert.equals("",newUserCreated.secretInformation,"secretInformation was not revealed")

    /*
        Login as that new user
    */
//    const newUserCreated=await myFetch(`/users`,`POST`,true,
//            {username:`qunitNonAdminUser`,password:`pass12345`},)
})