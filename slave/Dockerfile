FROM jenkinsci/ssh-slave
COPY ./files/.ssh /root/.ssh
RUN chmod -R 700 /root && sed -i -e 's/PermitRootLogin no/PermitRootLogin yes/' /etc/ssh/sshd_config
RUN apt-get update -y && apt-get install -y \
                                        apt-utils
RUN apt-get update -y && apt-get install -y \
                                        cmake \
  					g++ \
					build-essential \
					cppcheck \
                                        autoconf \
                                        libtool \
                                        stunnel4 \
                                        nghttp2


