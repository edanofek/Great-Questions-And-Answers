"# Great-Questions-And-Answers" 

	Great Question Eliminate inline-styles.
	----------------------------------------------

    Step 1:
        Please implement the following function upon page load:
        function eliminateInlineStyle()
        The function should traverse the document and replace every inline
        style with a dynamic css class definition.
        For example, running the eliminateInlineStyle function over the
        following document

        <html>
            <body>
                <div style="color: red">
                    <span style="padding: 4px;">hello world</span>
                </div>
            </body>
        </html>

        should produce something like:

        <html>
            <head>
                <style>
                    .class1 {color: red;}
                    .class2 {padding 4px;}
                </style>
            </head>
            <body>
                <div class="class1">
                    <span class="class2">hello world</span>
                </div>
            </body>
        </html>

    Step 2:
        Optimize the eliminateInlineStyle function to generate the least
        amount of dynamic classes for a given document.