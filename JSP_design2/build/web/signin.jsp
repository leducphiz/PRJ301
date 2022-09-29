<%@include file="template/header.jsp" %>
        <div id="content">
            <div id="form">
                <div id="form-title">
                    <span><a href="signup.jsp">SIGN UP</a></span>
                    <span><a href="signin.jsp" style="color: red;">SIGN IN</a></span>
                </div>
                <div id="form-content">
                    <form action="" method="post">
                        <label>Email<span style="color: red;">*</span></label><br/>
                        <input type="text"/><br/>
                        <span class="msg-error">Email is required</span><br/>
                        <label>Password<span style="color: red;">*</span></label><br/>
                        <input type="password"/><br/>
                        <span class="msg-error">Password is required</span><br/>
                        <div><a href="forgot.html">Forgot password?</a></div>
                        <input type="submit" value="SIGN IN"/><br/>
                        <input type="button" value="FACEBOOK LOGIN" style="background-color: #3b5998;"/><br/>
                        <input type="button" value="ZALO LOGIN" style="background-color: #009dff;margin-bottom: 30px;"/>
                    </form>
                </div>
            </div>
        </div>
<%@include file="template/footer.jsp" %>