SUMMARY = "xperia commandline utils"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
  udev-extraconf \
  coreutils \
  util-linux \
  psmisc \
  htop \
  vim \
  screen \
  "
