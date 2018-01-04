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

	Step 1
	Please implement the following function:
		function areEqual(element1, element2)
	Which returns true when the elements are DOM Equal

	Step 2
	Given an element, please implement the following function:
		function equalElements(element)
		Which returns all the equality groups.
		Equality group is defined as a list of all descendant elements which
		are DOM Equal
		[[elem1, elem2], …]