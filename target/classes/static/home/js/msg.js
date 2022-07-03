

var msg = {};

function errorMsg(content)
{
    layer.msg(content.toString(), {icon:5});
}

//dan'c
function successMsg(content)
{
    layer.msg(content,{icon:1});
}

msg.isEmpty = function(obj)
{
    if(obj == null || obj.length == 0 || obj == "" || obj == undefined || obj == 'undefined')
    {
        return true;
    }

    return false;
}

//手机号校验
msg.isPoneAvailable = function (telephone) {
    var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(telephone)) {
        return false;
    } else {
        return true;
    }
};

//邮箱验证
msg.isEmail = function(email)
{
    var checkEmail = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
    if(!checkEmail.test(email)) {
        return false;
    }
    return true;
}

//手机号验证
msg.isPhone = function(phone)
{
    var checkPhone = /^1[3|4|5|7|8]\d{9}$/;
    if(!checkPhone.test(phone)) {
        return false;
    }

    return true;
}

//身份证号验证
msg.isCard = function( card )
{
    var checkCard = /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    if(!checkCard.test(card)) {
        return false;
    }
    return true;
}

//年龄验证
msg.isAge = function( age )
{
    var checkAge =  /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
    if(!checkAge.test(age)) {
        return false;
    }

    return true;
}