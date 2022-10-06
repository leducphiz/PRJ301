<%@include file="./template/header.jsp" %>
<div id="content">
    <div id="form">
        <div id="form-title">
            <span><a href="signup" style="color: red;">SIGN UP</a></span>
            <span><a href="signin">SIGN IN</a></span>
        </div>
        <div id="form-content">
            <form action="" method="post">
                <label>Company name<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtCopName"/><br/>
                <span class="msg-error">Company name is required</span><br/>
                <label>Contact name<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtCName"/><br/>
                <span class="msg-error">Contact name is required</span><br/>
                <label>Contact title<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtTitle"/><br/>
                <span class="msg-error">Contact title required</span><br/>
                <label>Address<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtAddress"/><br/>
                <span class="msg-error">Address is required</span><br/>
                <label>Email<span style="color: red;">*</span></label><br/>
                <input type="text" name="txtEmail"/><br/>
                <span class="msg-error">Email is required</span><br/>
                <label>Password<span style="color: red;">*</span></label><br/>
                <input type="password" name="txtPass"/><br/>
                <span class="msg-error">Password is required</span><br/>
                <label>Re-Password<span style="color: red;">*</span></label><br/>
                <input type="password" name="txtRePass"/><br/>
                <span class="msg-error">Re-Password is required</span><br/>
                <div></div>
                <input type="submit" value="SIGN UP" style="margin-bottom: 30px;"/>
            </form>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>