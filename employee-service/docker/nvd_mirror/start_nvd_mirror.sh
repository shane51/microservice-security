docker pull sspringett/nvdmirror
docker rm -f mirror
docker run -dit   --name mirror   -p 80:80 sspringett/nvdmirror