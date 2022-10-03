<%@include file= "./template/header.jsp" %>
        <div id="content">
            <div id="content-left">
                <h3 style="font-weight: normal;">Welcome, Ph?m Ng?c Minh Châu</h3>
                <h3>Account Management</h3>
                <ul>
                    <a href="profile.jsp"><li>Personal information</li></a>
                </ul>
                <h3>My order</h3>
                <ul>
                    <a href="profile1.html"><li>All orders</li></a>
                    <a href="#"><li>Canceled order</li></a>
                </ul>
            </div>
            <div id="content-right">
                <div class="path">Personal information</b></div>
                <div class="content-main">
                    <div id="profile-content">
                        <div class="profile-content-col">
                            <div>Company name: <br/>FPTU</div>
                            <div>Contact name: <br/>Ph?m Ng?c Minh Châu</div>
                            <div>
                                <input type="submit" value="Edit info"/>
                            </div>
                        </div>
                        <div class="profile-content-col">
                            <div>Company title: <br/>CEO</div>
                            <div>Address: <br/>CNC Hoa Lac, Ha Noi</div>
                        </div>
                        <div class="profile-content-col">
                            <div>Email: <br/>chaupnm@fpt.edu.vn</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@include file="./template/footer.jsp" %>