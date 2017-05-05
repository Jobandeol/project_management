 <?php

$data = file_get_contents('php://input');

$decoded_data = json_decode($data , true );



$id = $decoded_data['id_key'];

$connection = mysqli_connect('localhost' , 'root' , '');

mysqli_select_db($connection , 'project_mangement');

$result = mysqli_query($connection , "Select * from project_details where U_id = '$id' ");

if($result)
	
	{
		while ($row = mysqli_fetch_assoc($result))
			$output[] = $row;
		$response['key'] = "done";
		$response['projects'] = $output;
		
		echo json_encode($response);
	}
	
	else {
		$response['response_key'] = "not done";
		
		echo json_encode($response);
		
	}

?>