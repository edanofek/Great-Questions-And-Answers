"# Great-Questions-And-Answers" 
	
	Great Question DOM logic checking.
	----------------------------------------------

	DOM Nodes are “DOM Equal” if they have the same number of
	descendant elements of every type.
	For example:
	<div>
		<img/>
		<span/>
		<div>
			<img/>
		</div>
	</div>
	is equal to:
	<div>
		<img/>
		<img/>
		<span>
			<div/>
		</span>
	</div>

	Please implement the following function:
		function areEqual(element1, element2)
	Which returns true when the elements are DOM Equal