DESCRIPTION = "android platform tools"
LICENSE = "APACHE-2.0"
LIC_FILES_CHKSUM = "file://MODULE_LICENSE_APACHE2;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI[md5sum] = "58af0003f5b7d5efc30366efee7bff49"
SRC_URI[sha256sum] = "c2531c303aec23b295b7899e1193f5007a402b10e5db9486f5156d7e79afd4bc"

SRC_URI = " \
  https://android.googlesource.com/platform/system/core/+archive/f6a78079a81a177a3edebc9980829cbf39bf6655.tar.gz \
  "

inherit allarch

BBCLASSEXTEND = "native"
RDEPENDS_mkbootimg = " \
  python-core \
  python-argparse \
  "

S = "${WORKDIR}"

do_install() {
  install -d ${D}/${bindir}
  install -m 0755 ${S}/mkbootimg/mkbootimg ${D}/${bindir}
}
