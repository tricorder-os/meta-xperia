DESCRIPTION = "Linux Kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit bootimg

DEPENDS += " \
  lzop-native \
  linux-firmware \
  bc-native \
  "

RDEPENDS_kernel-base += " \
  kernel-modules \
  kernel-devicetree \
  "

BRANCH = "linux-4.14.y"

SRCREV_kernel = "267ef1d332845c1d361ff3fd1d346613a12db773"

SRC_URI = " \
  git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=https;branch=${BRANCH};destsuffix=linux-${PV};name=kernel \
  "

S = "${WORKDIR}/linux-${PV}"

do_configure_append() {
  oe_runmake ${KERNEL_DEFCONFIG}
}
