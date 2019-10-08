<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose car option</title>
</head>
<body>


<style>
table, th, td {
	border: 1px solid black;
}
</style>

	<h2 align='left'>Basic Car Choice</h2>
	<table style="width: 50%">
		<tr>
			<td>Make/Model</td>
			<td>Toyota Landcruiser</td>
		</tr>

		<tr>
			<td>Color</td>
			<td><select name="Color">
					<option value="1">Cloud 9 White</option>
					<option value="2">Twilight Blue and Black</option>
					<option value="3">Unicorn RainBow colors</option>
			</select></td>
		</tr>

		<tr>
			<td>Transmission
			<td><select name="Transmission">
					<option value="trans1">automatic</option>
					<option value="trans2">standard</option>
			</select>
		</tr>

		<tr>
			<td>Side Impact Air Bags</td>
			<td><select name="airbag">
					<option value="air1">none</option>
					<option value="air2">selected</option>
			</select></td>
		</tr>

		<tr>
			<td>ABS/Traction Control</td>
			<td><select name="control">
					<option value="control1">Standard</option>
					<option value="control2">neither</option>
			</select></td>
		</tr>

		<tr>
			<td>Power Moonroof</td>
			<td><select name="powermoon">
					<option value="power1">yes</option>
					<option value="power2">no</option>
			</select></td>
		</tr>

	</table>

</body>
</html>