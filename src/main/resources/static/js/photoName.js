/*document.getElementById('upload').addEventListener("change", showName)
		function showName() {
			var fullPath = document.getElementById('upload').value;
			if (fullPath) {
				var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath
						.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
				var filename = fullPath.substring(startIndex);
				if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
					filename = filename.substring(1);
				}
				alert(filename);
			}
		}*/