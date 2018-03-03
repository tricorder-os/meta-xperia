DESCRIPTION = "Sony Xperia Linux Kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit bootimg

require recipes-kernel/linux/linux-dtb.inc

DEPENDS += " \
  lzop-native \
  linux-firmware \
  bc-native \
  "

RDEPENDS_kernel-base += "kernel-modules"
RDEPENDS_kernel-base += "kernel-devicetree"

BRANCH = "cm-14.1"

SRCREV_kernel = "6b0d8699a824949a2a956372bf99efa49d755b07"

SRC_URI = " \
  git://github.com/SonyLOS/android_kernel_sony_msm.git;protocol=https;branch=${BRANCH};destsuffix=linux-${PV};name=kernel \
  "

S = "${WORKDIR}/linux-${PV}"

do_configure_append() {
  oe_runmake ${KERNEL_DEFCONFIG}
}
