$(document).ready(function() {
      $("#upload-file-input").on("change", uploadFile);
      $("#upload-file-input1").on("change", uploadFile1);
      $("#upload-file-input2").on("change", uploadFile2);
    });

    /**
     * Upload the file sending it via Ajax at the Spring Boot server.
     */
    function uploadFile() {
      $.ajax({
        url: "/uploadFile",
        type: "POST",
        data: new FormData($("#upload-file-form")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
          // Handle upload success
          $("#upload-file-message").text("File succesfully uploaded");
        },
        error: function () {
          // Handle upload error
          $("#upload-file-message").text(
              "File not uploaded (perhaps it's too much big)");
        }
      });
    } // function uploadFile

    function uploadFile1() {
      $.ajax({
        url: "/uploadFile",
        type: "POST",
        data: new FormData($("#upload-file-form1")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
          // Handle upload success
          $("#upload-file-message1").text("File succesfully uploaded");
        },
        error: function () {
          // Handle upload error
          $("#upload-file-message1").text(
              "File not uploaded (perhaps it's too much big)");
        }
      });
    } // function uploadFile

    function uploadFile2() {
      $.ajax({
        url: "/uploadFile",
        type: "POST",
        data: new FormData($("#upload-file-form2")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
          // Handle upload success
          $("#upload-file-message2").text("File succesfully uploaded");
        },
        error: function () {
          // Handle upload error
          $("#upload-file-message2").text(
              "File not uploaded (perhaps it's too much big)");
        }
      });
    } // function uploadFile