<?php
	
class interf {
	
	public function buildTopSection($play){
		
		// Search function -- Could use this search function with some Javascript to find a particular panel?
        // <form>
        //   <div class="row collapse">
        //     <div class="small-8 columns">
        //       <input type="text">
        //     </div>
        //     <div class="small-4 columns">
        //       <a href="#" class="alert button">Search</a>
        //     </div>
        //   </div>
        // </form>
		
		$html = '
			<nav class="top-bar" id="topsection">
			  <ul class="title-area">
			    <li class="name">
			      <h1><a href="./">Navigators </a></h1>
			    </li>
			    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
			  </ul>

			  <section class="top-bar-section">
			    <ul class="left">
			      <li class="divider"></li>';
				
				if($play == 1){
				$html .= '
			      <li><a href="#" class="subbar" rel="status">Status</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="nav">Navigation</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="ls">Life support</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="arms">Armaments</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="crew">Crew</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="comms">Communications</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="energy">Energy</a></li>
			      <li class="divider"></li>
			      <li><a href="#" class="subbar" rel="hardware">Hardware</a></li>
  			      <li class="divider"></li>';
			  }
				  
			      // <li><a href="#">Main Item 2</a></li>
// 			      <li class="divider"></li>
// 			      <li class="has-dropdown"><a href="#">Main Item 3</a>
// 
// 			        <ul class="dropdown">
// 			          <li class="has-dropdown"><a href="#">Dropdown Level 1a</a>
// 
// 			            <ul class="dropdown">
// 			              <li><label>Dropdown Level 2 Label</label></li>
// 			              <li><a href="#">Dropdown Level 2a</a></li>
// 			              <li><a href="#">Dropdown Level 2b</a></li>
// 			              <li class="has-dropdown"><a href="#">Dropdown Level 2c</a>
// 
// 			                <ul class="dropdown">
// 			                  <li><label>Dropdown Level 3 Label</label></li>
// 			                  <li><a href="#">Dropdown Level 3a</a></li>
// 			                  <li><a href="#">Dropdown Level 3b</a></li>
// 			                  <li class="divider"></li>
// 			                  <li><a href="#">Dropdown Level 3c</a></li>
// 			                </ul>
// 			              </li>
// 			              <li><a href="#">Dropdown Level 2d</a></li>
// 			              <li><a href="#">Dropdown Level 2e</a></li>
// 			              <li><a href="#">Dropdown Level 2f</a></li>
// 			            </ul>
// 			          </li>
// 			          <li><a href="#">Dropdown Level 1b</a></li>
// 			          <li><a href="#">Dropdown Level 1c</a></li>
// 			          <li class="divider"></li>
// 			          <li><a href="#">Dropdown Level 1d</a></li>
// 			          <li><a href="#">Dropdown Level 1e</a></li>
// 			          <li><a href="#">Dropdown Level 1f</a></li>
// 			          <li class="divider"></li>
// 			          <li><a href="#">See all &rarr;</a></li>
// 			        </ul>
// 					
// 			      </li>
// 			      <li class="divider"></li>
// 			    </ul>

				$html .= '
				  
			</ul>
				<ul class="right">				
					<li class="divider"></li>
					<li><a href="about.php">About</a></li>
					<li class="divider"></li>
					<li><a href="contact.php">Contact</a></li>';
				   	if(isset($_SESSION["username"])){
	  			      $html .= '<li class="divider"></li>
	  			      <li><a href="services/logout.php">Logout</a></li>';
				  	}
				  
				  // <li class="divider hide-for-small"></li>
 // 			      <li class="has-dropdown"><a href="#">Main Item 4</a>
 // 
 // 			        <ul class="dropdown">
 // 			          <li><label>Dropdown Level 1 Label</label></li>
 // 			          <li class="has-dropdown"><a href="#" class="">Dropdown Level 1a</a>
 // 
 // 			            <ul class="dropdown">
 // 			              <li><a href="#">Dropdown Level 2a</a></li>
 // 			              <li><a href="#">Dropdown Level 2b</a></li>
 // 			              <li class="has-dropdown"><a href="#">Dropdown Level 2c</a>
 // 
 // 			                <ul class="dropdown">
 // 			                  <li><a href="#">Dropdown Level 3a</a></li>
 // 			                  <li><a href="#">Dropdown Level 3b</a></li>
 // 			                  <li><a href="#">Dropdown Level 3c</a></li>
 // 			                </ul>
 // 			              </li>
 // 			              <li><a href="#">Dropdown Level 2d</a></li>
 // 			              <li><a href="#">Dropdown Level 2e</a></li>
 // 			              <li><a href="#">Dropdown Level 2f</a></li>
 // 			            </ul>
 // 			          </li>
 // 			          <li><a href="#">Dropdown Level 1b</a></li>
 // 			          <li><a href="#">Dropdown Level 1c</a></li>
 // 			          <li class="divider"></li>
 // 			          <li><label>Dropdown Level 1 Label</label></li>
 // 			          <li><a href="#">Dropdown Level 1d</a></li>
 // 			          <li><a href="#">Dropdown Level 1e</a></li>
 // 			          <li><a href="#">Dropdown Level 1f</a></li>
 // 			          <li class="divider"></li>
 // 			          <li><a href="#">See all &rarr;</a></li>
 // 			        </ul>
 // 			      </li>
 // 			      <li class="divider"></li>
 // 			      <li class="has-form">
 // 
 // 			      </li>
 // 			      <li class="divider show-for-small"></li>
 // 			      <li class="has-form">
 // 			        <a class="button" href="#">Button!</a>
 // 			      </li>
			$html .= '</ul>
			  </section>
			</nav>';
		
		return $html;
		
	}
	
	public function buildActionBar(){
		$html .= '
				<div class="row" id="actionbar">
					<div class="large-12 columns">
					<h5>Action bar: WARNING! Your life support resources will be depleted before you reach your destination!</h5>
					</div>
				</div>';
			
		return $html;
	}
	
	public function buildMainSection(){ // <dyn> tag represents a dynamic variable?
		
		$html = '
		<div class="large-8 columns" id="mainsection">
			<div class="subsystem" id="status">	
				<h2>Status interface</h2>
				<div class="subsection" id="health">
					<h3 class="subheader">Health: <dyn id="healthVal">100</dyn>%</h3>
				</div>
				<div class="subsection" id="systems">
					<h3 class="subheader">All systems functional</h3>
				</div>
				<div class="subsection" id="overview">
					<h3 class="subheader">Ship overview</h3>
				</div>
			</div>
	
			<div class="subsystem" id="nav">
				<h2>Navigation interface</h2>
				<div class="subsection" id="current">
					<h3 class="subheader">Current system: Sol</h3>
					<h3 class="subheader">Target system: Alpha Centauri</h3>
					<h3 class="subheader">Estimated distance: 4.367 light years</h3>
					<h3 class="subheader">Estimated journey time: Approximately 3.12 days</h3>
				</div>
			</div>
	
			<div class="subsystem" id="ls">
				<h2>Life support interface</h2>
				<div class="subsection" id="current">
					<h3 class="subheader">Breathing conditions: Excellent</h3>
					<h3 class="subheader">iNurse: 100% operational</h3>
					<h3 class="subheader">Average temperature: 21c</h3>
					<h3 class="subheader">Estimated lifespan: 37 hours</h3>
				</div>
			</div>
	
			<div class="subsystem" id="arms">
				<h2>Armaments interface</h2>
			</div>
	
			<div class="subsystem" id="crew">
				<h2>Crew management interface</h2>
			</div>
	
			<div class="subsystem" id="comms">
				<h2>Communications interface</h2>
				<div class="subsection" id="communicables">
					<h3 class="subheader">Available objects for communications</h3>
					<h4 class="subheader">A ship</h4>
					<h4 class="subheader">A station</h4>
					<h4 class="subheader">A planet</h4>
					<h4 class="subheader">A miner</h4>
				</div>
			</div>
	
			<div class="subsystem" id="energy">
					<h2>Energy management interface</h2>
			</div>
	
			<div class="subsystem" id="hardware">
				<h2>Hardware inspector</h2>
				<div class="large-3 columns">
					<div class="subsection">
					<h4 class="subheader">Engine</h4>
					<h6 class="subheader">Make: Cassandra 3</h5>
					<h6 class="subheader">Max speed: 1.4 LY/d</h5>
					<h6 class="subheader">Mileage: 167 LY</h5>
					</div>
				</div>
				<div class="large-3 columns">
					<div class="subsection">
					<h4 class="subheader">ECLSS</h4>
					<h6 class="subheader">Make: Theresa 7</h5>
					<h6 class="subheader">Capacity: 6 (human)</h5>
					<h6 class="subheader">Expectancy: 37 hours</h5>
					</div>
				</div>
				<div class="large-3 columns">
					<div class="subsection">
					<h4 class="subheader">Generator</h4>
					<h6 class="subheader">Make: </h5>
					<h6 class="subheader">Maximum output: </h5>
					<h6 class="subheader">Maximum operating temp: </h5>
					</div>
				</div>
				<div class="large-3 columns">
					<div class="subsection">
					<h4 class="subheader">Computer</h4>
					<h6 class="subheader">Make: </h5>
					<h6 class="subheader">CPU: </h5>
					<h6 class="subheader">Memory: </h5>
					</div>
				</div>
			</div>
		</div>';
		
		return $html;
	}
	
	public function buildSideSection(){
		
		$html .= '
		<div class="large-4 columns" id="sidesection">
			<h2>Side bar</h2>
			<h3 class="subheader" id="statusBar">Information shows up here that does not change when you change interfaces, if that makes sense.</h3>
		</div>';
		return $html;
		
	}

}
	
?>