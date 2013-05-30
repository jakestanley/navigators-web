<?php
	
class interf {
	
	public function buildTopSection(){
		
		// Search function
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
		
		// $html = '
		// 	<div class="row" id="subbar">
		// 		<div class="large-12 columns">
		// 			<ul class="button-group">
		// 				<li><a href="#" class="button small secondary" rel="status">Status</a></li>
		// 				<li><a href="#" class="button small secondary" rel="nav">Navigation</a></li>
		// 				<li><a href="#" class="button small secondary" rel="ls">Life</a></li>
		// 				<li><a href="#" class="button small secondary" rel="arms">Arms</a></li>
		// 				<li><a href="#" class="button small secondary" rel="crew">Crew</a></li>
		// 				<li><a href="#" class="button small secondary" rel="comms">Comms</a></li>
		// 				<li><a href="#" class="button small secondary" rel="energy">Energy</a></li>
		// 				<li><a href="#" class="button small secondary" rel="hardware">Hardware</a></li>
		// 				<li><a href="#" class="button small secondary" rel="somebutton1">button9</a></li>
		// 				<li><a href="#" class="button small secondary" rel="somebutton2">button10</a></li>
		// 				<li><a href="#" class="button small secondary" rel="somebutton3">button11</a></li>
		// 				<li><a href="#" class="button small secondary" rel="somebutton4">button12</a></li>
		// 			</ul>
		// 		</div>
		// 	</div>';
		
		$html = '
			<nav class="top-bar" id="topsection">
			  <ul class="title-area">
			    <li class="name">
			      <h1><a href="#">Navigators </a></h1>
			    </li>
			    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
			  </ul>

			  <section class="top-bar-section">
			    <ul class="left">
				
			      <li class="divider"></li>
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
				  
			</ul>';
				  
				  
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
			    <!-- Right Nav Section -->
			    <ul class="right">
				
				  <li class="divider"></li>
				  <li><a href="#">About</a></li>
			      <li class="divider"></li>
			      <li><a href="#">Contact</a></li>
			      <li class="divider"></li>
			      <li><a href="#">Logout</a></li>';
				  
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
	
	public function buildMainSection(){
		
		$html = '
		<div class="large-8 columns" id="mainsection">
			<div class="subsystem" id="status">	
				<div class="row">
					<h2>Status interface</h2>
					<div class="subsection" id="health">
						<h3 class="subheader">Health: 100%</h3>
					</div>
					<div class="subsection" id="systems">
						<h3 class="subheader">All systems functional</h3>
					</div>
					<div class="subsection" id="overview">
						<h3 class="subheader">Ship overview</h3>
					</div>
				</div>
			</div>
	
			<div class="subsystem" id="nav">
				<div class="row">
					<h2>Navigation interface</h2>
					<div class="subsection" id="current">
						<li>Current system: Sol</li>
						<li>Target system: Alpha Centauri</li>
						<li>Estimated distance: 4.367 light years</li>
						<li>Estimated journey time: Approximately 3.12 days</li>
					</div>
				</div>
			</div>
	
			<div class="subsystem" id="ls">
				<div class="row">
					<h2>Life support interface</h2>
					<div class="subsection" id="current">
						<li>Breathing conditions: Excellent</li>
						<li>Auto-medicate: 100% operational</li>
						<li>Average temperature: 21c</li>
						<li>Estimated lifespan: 1,355 hours</li>
					</div>
				</div>
			</div>
	
			<div class="subsystem" id="arms">
				<div class="row">
					<h2>Armaments interface</h2>
				</div>
			</div>
	
			<div class="subsystem" id="crew">
				<div class="row">
					<h2>Crew management interface</h2>
				</div>
			</div>
	
			<div class="subsystem" id="comms">
				<div class="row">
					<h2>Communications interface</h2>
					<div class="subsection" id="communicables">
						<h3>Available objects for communications</h3>
						<div class="subsubsection" id="communicable">A ship</div>
						<div class="subsubsection" id="communicable">A station</div>
						<div class="subsubsection" id="communicable">A planet</div>
						<div class="subsubsection" id="communicable">A miner</div>
					</div>
				</div>
			</div>
	
			<div class="subsystem" id="energy">
				<div class="row">
					<h2>Energy management interface</h2>
				</div>
			</div>
	
			<div class="subsystem" id="hardware">
				<div class="row">
					<h2>Hardware inspector</h2>
					<div class="subsection" id="installed">
						<div class="subsubsection" id="engine">
							<li>Installed engine:</li>
							<li>Cassandra 3</li>
							<li>Capable of a maximum speed of 1.4ly/d</li>
						</div>
						<div class="subsubsection" id="support">
							<li>Installed life support:</li>
							<li>Theresa 7</li>
							<li>Capable of supporting up to 5 life forms</li>
						</div>
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
			<h3 class="subheader">Information shows up here that does not change when you change interfaces, if that makes sense.</h3>
		</div>';
		return $html;
		
	}
	
	public function buildBottomSection(){
		$html .= '
				<div class="row" id="bottomsection">
					<div class="large-12 columns">Action bar</div>
				</div>';
			
		return $html;
	}

}
	
?>