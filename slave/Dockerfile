FROM jenkinsci/ssh-slave
ADD https://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.16/swarm-client-3.16.jar /opt/swarm-client.jar
USER root
RUN chmod 755 /opt/swarm-client.jar
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
                                        nghttp2 \
                                        zip \
                                        ccache
#RUN ln -s ccache /usr/bin/x86_64-linux-gnu-g++-6  && ln -s ccache /usr/bin/x86_64-linux-gnu-gcc-6 
#&& ln -sv /usr/bin/cc ccache && ln -sv /usr/bin/c++ ccache



