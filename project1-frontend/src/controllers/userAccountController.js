
/*
    Attemping to use controllers on the frontend.
    These can manage state/data.
    These can hold functions which can be called from React OR qunit for testing.

    Attempting to make the app testable.
    React side will go through menus/pages/modals and 
    make things look pretty, but I would like it to be 
    as dumb as possible so we aren't tangled in state management hell.
*/

export default class userAccountController
{
    static loggedInUser=null
    static newUserCreated=null


    static async register(username,password,secretInformation="default secret info")
    {
        console.log(`userAccountController register() ${username} ${password} ${secretInformation}`)
        const response=await fetch(`/project1-back/users/register`,{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({
                "name":username,
                "password":password,
                "secretInformation":secretInformation
            })
        })
        let body=await response.json()

        if(response.status!=200)
            throw new Error(`response status ${response.status} `+JSON.stringify(body.errorMessage))

        userAccountController.newUserCreated=body
        console.log(`userAccountController.newUserCreated=`,userAccountController.newUserCreated)
    }

    static async login(username,password)
    {
        console.log(`userAccountController login() ${username} ${password}`)
        const response=await fetch(`/project1-back/users/login`,{
            method:"POST",
            headers:{
                "Content-Type":"application/json",
                "username":username,
                "password":password
            }
        })
        let body=await response.json()

        if(response.status!=200)
            throw new Error(`response status ${response.status} `+JSON.stringify(body.errorMessage))
        
        userAccountController.loggedInUser=body
        console.log(`userAccountController.loggedInUser=`,userAccountController.loggedInUser)
    }

    static async myPrivateInfo()
    {
        console.log(`userAccountController myPrivateInfo()`)
        const response=await fetch(`/project1-back/users/my-private-info`,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                tokenId:        userAccountController.loggedInUser.tokenId,
                tokenPassword:  userAccountController.loggedInUser.tokenPassword
            }
        })
        let body=await response.json()

        if(response.status!=200)
            throw new Error(`response status ${response.status} `+JSON.stringify(body.errorMessage))
        userAccountController.loggedInUser.secretInformation=body.secretInformation
    }

    static async logout()
    {
        console.log(`userAccountController logout()`)
        const response=await fetch(`/project1-back/users/logout`,{
            method:"POST",
            headers:{
                "Content-Type":"application/json",
                tokenId:        userAccountController.loggedInUser.tokenId,
                tokenPassword:  userAccountController.loggedInUser.tokenPassword
            }
        })
        let body=await response.json()

        if(response.status!=200)
            throw new Error(`response status ${response.status} `+JSON.stringify(body.errorMessage))
        
        return body.message
    }

    
}