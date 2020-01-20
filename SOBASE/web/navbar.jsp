 <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="http://localhost:8080/SOBASE/list-room.do?sort=asc">RoomFinder</a>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/SOBASE/login.do">Login</a>
              </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="http://localhost:8080/SOBASE/list-room.do?sort=asc" method="get">
                <input class="form-control mr-sm-2" name="location" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-dark" type="submit">Search</button>
                <label class="order-label">
                    <input type="radio" name="sort" value="asc" checked> Asc  
                </label>
                <label class="order-label">
                    <input type="radio" name="sort" value="desc"> Desc  
                </label>
            </form>
          </div>
        </nav>
