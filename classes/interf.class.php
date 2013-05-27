<?php
	
class interf {
	
	public function buildSubsystemsBar(){ // All these systems are getting too complex. Remember, it's complexity in as simple a layout as possible. If that makes any sense at all.
		
		$html = '<div id="subsystems">
			<button class="subbar" id="status">Status</button>
			<button class="subbar" id="nav">Navigation</button>
			<button class="subbar" id="ls">Life Support</button>
			<button class="subbar" id="arms">Armaments</button>
			<button class="subbar" id="crew">Crew</button>
			<button class="subbar" id="comms">Communications</button>
			<button class="subbar" id="energy">Energy</button>
			<button class="subbar" id="hardware">Hardware</button>
		</div>';
		
		return $html;
	}
	
	public function buildSubsystems(){
		
		$html = '
		<div class="subsystem" id="status">
			<h2>Status interface</h2>
			<div class="subsection" id="health">
				<h3>Health: 100%</h3>
			</div>
			<div class="subsection" id="systems">
				<h3>All systems functional</h3>
			</div>
		</div>
		<div class="subsystem" id="nav">
			<h2>Navigation interface</h2>
			<div class="subsection" id="current">
				<li>Current system: Sol</li>
				<li>Target system: Alpha Centauri</li>
				<li>Estimated distance: 4.367 light years</li>
				<li>Estimated journey time: Approximately 3.12 days</li>
			</div>
		</div>
		<div class="subsystem" id="ls">
			<h2>Life support interface</h2>
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
				<h3>Available objects for communications</h3>
				<div class="subsubsection" id="communicable">A ship</div>
				<div class="subsubsection" id="communicable">A station</div>
				<div class="subsubsection" id="communicable">A planet</div>
				<div class="subsubsection" id="communicable">A miner</div>
			</div>
		</div>
		<div class="subsystem" id="energy">
			<h2>Energy management interface</h2>
		</div>
		<div class="subsystem" id="hardware">
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
		</div>';
		
		return $html;
		
	}
	
	
}
	
?>