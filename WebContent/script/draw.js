drawMind = function (mindStatus){
	var tmp = mindStatus;
	var data = new Array();
	for(var i =0;i < 10;i++){
		data[i] = tmp%10;
		tmp = tmp/10;
	}
	   
	// Create the Line chart object. The arguments are the canvas ID and the data array.
	var line = new RGraph.Line("mind", data);
	        
	// The way to specify multiple lines is by giving multiple arrays, like this:
	// var line = new RGraph.Line("myLine", [4,6,8], [8,4,6], [4,5,3]);
	        
	// Configure the chart to appear as you wish.
	line.Set('chart.background.barcolor1', 'white');
	line.Set('chart.background.barcolor2', 'white');
	line.Set('chart.background.grid.color', 'rgba(238,238,238,1)');
	line.Set('chart.colors', ['green']);
	line.Set('chart.ylabels', false);
	line.Set('chart.linewidth', 5);
	line.Set('chart.variant', '3d');
	line.Set('chart.shadow', 'true');
	line.Set('chart.hmargin', 5);
	line.Set('chart.gutter.left', 40);
	        
	// Now call the .Draw() method to draw the chart.
	line.Draw();
}

drawBody = function (bodyStatus){
	var tmp = bodyStatus;
	var data = new Array();
	for(var i =0;i < 10;i++){
		data[i] = tmp%10;
		tmp = tmp/10;
	}
	   
	// Create the Line chart object. The arguments are the canvas ID and the data array.
	var line = new RGraph.Line("body", data);
	        
	// The way to specify multiple lines is by giving multiple arrays, like this:
	// var line = new RGraph.Line("myLine", [4,6,8], [8,4,6], [4,5,3]);
	        
	// Configure the chart to appear as you wish.
	line.Set('chart.background.barcolor1', '#ddd');
	line.Set('chart.background.barcolor2', '#ddd');
	line.Set('chart.background.grid.color', 'rgba(238,238,238,1)');
	line.Set('chart.colors', ['green']);
	line.Set('chart.ylabels', false);
	line.Set('chart.linewidth', 5);
	line.Set('chart.variant', '3d');
	line.Set('chart.shadow', 'true');
	line.Set('chart.hmargin', 5);
	line.Set('chart.gutter.left', 40);
	        
	// Now call the .Draw() method to draw the chart.
	line.Draw();
}