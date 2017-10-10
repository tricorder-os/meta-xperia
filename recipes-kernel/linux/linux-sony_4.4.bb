DESCRIPTION = "Sony Xperia Linux Kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc

DEPENDS += " \
  lzop-native \
  linux-firmware \
  "

RDEPENDS_kernel-base += "kernel-modules"
RDEPENDS_kernel-base += "kernel-devicetree"

SRC_URI = " \
  https://github.com/sonyxperiadev/kernel/archive/aosp/LA.UM.5.7.r1.tar.bz2 \
  "

S = "${WORKDIR}/linux-${PV}"
